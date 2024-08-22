package com.simplon.forknow.controller;

import com.simplon.forknow.dto.LoginDto;
import com.simplon.forknow.model.Utilisateur;
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

import java.util.Optional;

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
    public String login(Model model, Authentication authentication) {
        // Ajoute l'utilisateur au modèle pour le menu de navigation
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if(utilisateur.isPresent()) {
            model.addAttribute("currentUser", utilisateur.orElse(null));
        }
        return "login";
    }


}
