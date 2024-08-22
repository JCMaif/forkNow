package com.simplon.forknow.controller;

import com.simplon.forknow.dto.LoginDto;
import com.simplon.forknow.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, UtilisateurService utilisateurService) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("LoginDto", new LoginDto());
        return "login";
    }

//    @PostMapping("/login")
//    public String authenticateUser(@Valid @ModelAttribute("LoginDto") LoginDto loginDto, Model model) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
//            );
//
//            return "redirect:/restaurants-list";
//
//        } catch (AuthenticationException e) {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
}
