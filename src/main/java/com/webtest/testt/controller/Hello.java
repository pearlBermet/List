package com.webtest.testt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hel")
    public String hello(){
        return "hello world";
    }
}
