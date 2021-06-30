package com.onetwo.library_management.controller;

import com.onetwo.library_management.model.User;
import com.onetwo.library_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UIUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listAccounts() {
        ModelAndView modelAndView = new ModelAndView("user"); // users.jsp
        List<User> users = userService.getUsers();
        System.out.println(users);
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/details/{userId}", method = RequestMethod.GET)
    public ModelAndView accountDetail(@PathVariable("userId") String id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView("details"); //i.e details.jsp

        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
