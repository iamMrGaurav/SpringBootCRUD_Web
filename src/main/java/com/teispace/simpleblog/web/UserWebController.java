package com.teispace.simpleblog.web;
import com.teispace.simpleblog.entities.User;
import com.teispace.simpleblog.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImplementation userService;


    @Autowired
    public UserController(UserServiceImplementation userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUsers(Model model){

        List<User> users = userService.getAllUsers();
        return "user";
    }
}
