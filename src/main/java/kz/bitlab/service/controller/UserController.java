package kz.bitlab.service.controller;

import kz.bitlab.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    @PreAuthorize("isAnonymous()")
    public String signUp(){
        return "sign-up";
    }

    @PostMapping("/registration")
    @PreAuthorize("isAnonymous()")
    public String registration(@RequestParam("user_email") String email,
                               @RequestParam("user_password") String password,
                               @RequestParam("user_repeat_password") String repeatPassword,
                               @RequestParam("user_full_name") String fullName){

        userService.singUp(email, password, repeatPassword, fullName);

        return "redirect:/sign-up?success";
    }

    @GetMapping("/change-password")
    @PreAuthorize("isAuthenticated()")
    public String changePassword(){
        return "change-password";
    }

    @PostMapping("/save-password")
    @PreAuthorize("isAuthenticated()")
    public String savePassword(@RequestParam("user_old_password") String old,
                               @RequestParam("user_new_password") String newP,
                               @RequestParam("user_repeat_password") String repeat){
        userService.updatePassword(old, newP, repeat);
        return "redirect:/change-password?success";
    }

}
