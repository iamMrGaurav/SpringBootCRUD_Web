package com.teispace.simpleblog.web;
import com.teispace.simpleblog.entities.User;
import com.teispace.simpleblog.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserWebController {

    private final UserServiceImplementation userService;


    @Autowired
    public UserWebController(UserServiceImplementation userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        model.addAttribute("name","");
        return "user";
    }

    @GetMapping ("/{id}")
    public String deleteUser(@PathVariable String id) throws Exception {
        userService.deleteUser(Integer.parseInt(id));

        return "redirect:/users";
    }

    @GetMapping ("/add")
    public String getAddUser(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }
    @PostMapping ("/add")
    public String addUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/users";
    }


    @GetMapping ("/update/{id}")
    public String getUpdateUser(Model model,@PathVariable String id){
           try {
               User user = userService.getUserById(Integer.parseInt(id));
               model.addAttribute("user", user);
               return "update";
           }catch (Exception e){
               model.addAttribute("user", new User());
               return "update";
           }

    }

    @PostMapping ("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable String id) throws Exception {
        userService.updateUser(user,Integer.parseInt(id));
        return "redirect:/users";
    }

    @PostMapping("/search")
    public String getUsers(@RequestParam(required = false) String name,Model model){

        List<User> users = userService.findUserByName(name);
        model.addAttribute("users",users);
        model.addAttribute("name",name);
        return "user";
    }

}
