package com.onetwo.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String list() {
        return "index";
    }

    //	todo: delete
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //	todo: delete
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
