package com.webtest.testt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/04")
    public String goodbye() {
        return "Goodbye Bermet";
    }

    @GetMapping("/rr")
    public int plus(){
        return 8+8;
    }
}
