package kz.bitlab.service.service;

import kz.bitlab.service.model.Permission;
import kz.bitlab.service.model.User;
import kz.bitlab.service.repository.PermissionRepository;
import kz.bitlab.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (Objects.nonNull(user)) {
            return user;
        }
        throw new UsernameNotFoundException("User with this email not found: " + username);    }

    @Override
    public boolean signIn(String email, String password){
        User user = userRepository.findByUsername(email);

        System.out.println(user.getPassword());

        if (passwordEncoder.matches(password, user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public Boolean singUp(String email, String password, String repeatPassword, String fullName) {

        User user = userRepository.findByUsername(email);

        if (Objects.isNull(user)){

            if (password.equals(repeatPassword)){

                Permission permission = permissionRepository.findByPermission("ROLE_USER");

                List<Permission> roles = new ArrayList<>();

                roles.add(permission);

                User newUser = new User();
                newUser.setFullName(fullName);
                newUser.setUsername(email);
                newUser.setPassword(passwordEncoder.encode(password));
                newUser.setRole(roles);

                userRepository.save(newUser);

                return true;
            }

        }

        return false;
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            return user;
        }
        return null;
    }

    @Override
    public Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword) {

        User user = getCurrentUser();

        if (Objects.nonNull(user)){
            if (passwordEncoder.matches(oldPassword, user.getPassword()))
                if (newPassword.equals(repeatNewPassword)){
                    user.setPassword(passwordEncoder.encode(newPassword));
                    userRepository.save(user);
                    return true;
                }
            }
        return false;
    }
}
