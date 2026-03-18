package kz.bitlab.service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Boolean singUp(String email, String password, String repeatPassword, String fullName);

    Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword);

    boolean signIn(String email, String password);

}
