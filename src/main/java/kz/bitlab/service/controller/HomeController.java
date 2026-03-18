//package kz.bitlab.service.controller;
//
//import kz.bitlab.service.service.UserService;
//import kz.bitlab.service.service.UserServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.security.Principal;
//
//@Controller
//@RequiredArgsConstructor
//public class HomeController {
//
//    private final UserService userService;
//    private final UserServiceImpl userServiceImpl;
//
//    @GetMapping("/")
//    public String indexPage(){
//        return "index";
//    }
//
//    @GetMapping("/sign-in")
//    @PreAuthorize("isAnonymous()")
//    public String loginPage(Model model){
//        return "sign-in";
//    }
//
//    @GetMapping("/profile")
//    @PreAuthorize("isAuthenticated()")
//    public String profile(Model model, Principal principal) { // Principal или Authentication
//        // Получаем пользователя по email из Principal
//        var user = userService.loadUserByUsername(principal.getName());
//        model.addAttribute("current", user);
//        return "profile";
//    }
//
////    @GetMapping("/profile")
////    @PreAuthorize("isAuthenticated()")
////    public String profile(Model model){
////        return "profile";
////    }
//
//}
