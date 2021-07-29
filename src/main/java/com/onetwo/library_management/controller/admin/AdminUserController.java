package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@AllArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @RequestMapping("/admin/users")
    public String findAllUsers(Model model) {
        final List<User> users = userService.findAllUsers();
        User new_user = new User();

//        new_user.setEmail("");
//        new_user.setPassword("");
//        new_user.setUsername("");
//        new_user.setPhone("");

        model.addAttribute("users", users);
//        model.addAttribute("new_user", new_user);

        return "list-users";
    }

    @GetMapping("/admin/addUser")
    public String showCreateForm(User user) {
        return "add-user";
    }

    @RequestMapping("/admin/add-user")
    public String createUser(User new_user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.signUpUser(new_user);
        model.addAttribute("user", userService.findAllUsers());
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/updateUser/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final User user = userService.findUserById(id);

        model.addAttribute("user", user);
        return "update-user";
    }

    @RequestMapping("/admin/update-user/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-user";
        }

        userService.updateUser(user);
        model.addAttribute("user", userService.findAllUsers());
        return "redirect:/admin/users";
    }

    @RequestMapping("/admin/remove-user/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("user", userService.findAllUsers());
        return "redirect:/admin/users";
    }

}