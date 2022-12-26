package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.User;
import com.example.studentwebservice.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("registration")
    private String createUser(@RequestBody User user){
        userService.createUser(user);
        return "Registration complete!";
    }

    @GetMapping("login")
    private String login(@RequestBody User user){
        try {
            userService.loadUserByUsername(user.getUsername());
        }catch (UsernameNotFoundException e){
            return e.getMessage();
        }
        return "Logged on!";
    }

    @GetMapping("user/list")
    private List<User> list(){
        return userService.list();
    }

}
