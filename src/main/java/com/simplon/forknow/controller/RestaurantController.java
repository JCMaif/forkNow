package com.simplon.forknow.controller;

import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class RestaurantController {
    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;

    @Autowired
    public RestaurantController(AuthenticationManager authenticationManager, UtilisateurService utilisateurService) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
    }
    @GetMapping("/restaurants-list")
    public String restaurantsList(Model model, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if(utilisateur.isPresent()) {
            model.addAttribute("currentUser", utilisateur.orElse(null));
        }
        System.out.println("utilisateur :" + utilisateur.get());
        return "restaurants-list";
    }
}
