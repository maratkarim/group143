package kz.bitlab.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public String getManager(){
        return "manager";
    }

    @GetMapping("/prosto")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdmin(){
        return "admin";
    }

}
