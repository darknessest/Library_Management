package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.ConfirmationToken;
import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.service.ConfirmationTokenService;
import com.onetwo.library_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

//    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/register")
    String signUpPage(User user) {
        return "register";
    }

    @PostMapping("/register")
    String signUp(User user) {
        userService.signUpUser(user);
        return "redirect:/login";
    }

}