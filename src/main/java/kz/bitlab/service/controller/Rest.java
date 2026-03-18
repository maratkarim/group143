package kz.bitlab.service.controller;

import kz.bitlab.service.dto.UserDto;
import kz.bitlab.service.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/hello")
public class Rest {

    @GetMapping()
    public String rest(){
        return "hello";
    }

}
