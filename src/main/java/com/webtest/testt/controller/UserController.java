package com.webtest.testt.controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping
    public String home(){
        return "Something";
    }


}
