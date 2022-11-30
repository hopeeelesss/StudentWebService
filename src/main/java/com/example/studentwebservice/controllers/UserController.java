package com.example.studentwebservice.controllers;

import com.example.studentwebservice.dto.RegistrationDTO;
import com.example.studentwebservice.models.User;
import com.example.studentwebservice.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    private String createUser(@RequestBody User user){
        userService.createUser(user);
        return "Registration complete!";
    }


}
