package com.simplon.forknow.controller;

import com.simplon.forknow.model.Cuisine;
import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.service.CuisineService;
import com.simplon.forknow.service.UtilisateurService;
import com.simplon.forknow.service.impl.CuisineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CuisineController {
    private final CuisineService cuisineService;
    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;

    @Autowired
    public CuisineController(AuthenticationManager authenticationManager, UtilisateurService utilisateurService, CuisineService cuisineService) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.cuisineService = cuisineService;
    }

    @GetMapping("/cuisines-list")
    public String getAllCuisines(Model model, Authentication authentication){
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if(utilisateur.isPresent()) {
            model.addAttribute("currentUser", utilisateur.orElse(null));
        }
        List<Cuisine> cuisines = cuisineService.findAllCuisines();
        model.addAttribute("cuisines", cuisines);
        return "cuisines-list";
    }


}
