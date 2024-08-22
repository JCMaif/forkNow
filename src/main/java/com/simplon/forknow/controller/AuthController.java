package com.simplon.forknow.controller;

import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AuthController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public AuthController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if (utilisateur.isPresent()) {
            model.addAttribute("currentUser", utilisateur.get());
        }
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
