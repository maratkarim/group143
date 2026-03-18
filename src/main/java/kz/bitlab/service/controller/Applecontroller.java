package kz.bitlab.service.controller;

import kz.bitlab.service.service.AppleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Applecontroller {

    private final AppleService appleService;

//    @GetMapping("/")
//    public String getAll()




}
