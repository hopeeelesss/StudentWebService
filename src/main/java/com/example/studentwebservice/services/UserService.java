package com.example.studentwebservice.services;

import com.example.studentwebservice.dto.RegistrationDTO;
import com.example.studentwebservice.models.Role;
import com.example.studentwebservice.models.User;
import com.example.studentwebservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;


    public void createUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles((Set.of(Role.USER)));
        userRepository.save(user);
    }
}
