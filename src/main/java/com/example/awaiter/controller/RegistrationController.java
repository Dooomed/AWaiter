package com.example.awaiter.controller;
/*
import com.example.awaiter.model.RegistrationForm;
import com.example.awaiter.model.User;
import com.example.awaiter.repository.UserRepository;
import com.example.awaiter.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {


    private final CustomUserDetailsService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> processRegistration(@RequestBody RegistrationForm form) throws Exception {
        User newUser = (User) userService.saveUser(form.toUser(passwordEncoder));

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> processLogin(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}*/
