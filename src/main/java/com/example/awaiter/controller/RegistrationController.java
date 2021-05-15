package com.example.awaiter.controller;

import com.example.awaiter.model.RegistrationForm;
import com.example.awaiter.repository.UserRepository;
import com.example.awaiter.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {


    private final CustomUserDetailsService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("form", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("form") RegistrationForm form) throws Exception {
        userService.saveUser(form.toUser(passwordEncoder));

        return "redirect:/login";
    }
}
