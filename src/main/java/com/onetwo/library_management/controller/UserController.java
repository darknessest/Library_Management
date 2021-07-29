package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/user/edit")
    public String showUpdateForm(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("user", user);
        return "edit-user-info";
    }

    @PostMapping("/user/update")
    public String updateUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-user-info";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User auth_user = (User) auth.getPrincipal();

        if (user.getEmail() != null)
            auth_user.setEmail(user.getEmail());
        if (user.getPassword() != null)
            auth_user.setPassword(user.getPassword());
        if (user.getUsername() != null)
            auth_user.setUsername(user.getUsername());
        if (user.getName() != null)
            auth_user.setName(user.getName());
        if (user.getPhone() != null)
            auth_user.setPhone(user.getPhone());
        if (user.getUserRole() != null)
            auth_user.setUserRole(user.getUserRole());
        if (user.getLocked() != null)
            auth_user.setLocked(user.getLocked());
        if (user.getEnabled() != null)
            auth_user.setEnabled(user.getEnabled());

        userService.updateUser(auth_user);
        return "redirect:/user/update";
    }

    @GetMapping("/register")
    String signUpPage(User user) {
        return "register";
    }

    @PostMapping("/register")
    String signUp(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userService.signUpUser(user);
        return "redirect:/login";
    }

}