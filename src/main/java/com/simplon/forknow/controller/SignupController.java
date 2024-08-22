package com.simplon.forknow.controller;

import com.simplon.forknow.dto.SignupDto;
import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

@Controller
public class SignupController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public SignupController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/signup")
    public String signup(@Valid Model model, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        model.addAttribute("currentUser", utilisateur.orElse(null));
        return "signup";
    }

    @PostMapping("/signup/save")
    public String signupUser(@ModelAttribute SignupDto userMapping) {
        if (!userMapping.getPassword().equals(userMapping.getPasswordConfirm())) {
            return "redirect:/signup?error";
        }


        utilisateurService.saveUtilisateur(userMapping);
        return "redirect:/login";
    }
}
