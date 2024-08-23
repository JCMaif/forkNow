package com.simplon.forknow.controller;

import com.simplon.forknow.model.Restaurant;
import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.service.CuisineService;
import com.simplon.forknow.service.RestaurantService;
import com.simplon.forknow.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class RestaurantController {
    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;
    private final RestaurantService restaurantService;
    private final CuisineService cuisineService;

    @Autowired
    public RestaurantController(AuthenticationManager authenticationManager, UtilisateurService utilisateurService, RestaurantService restaurantService, CuisineService cuisineService) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.restaurantService = restaurantService;
        this.cuisineService = cuisineService;
    }
    @GetMapping("/restaurants-list")
    public String restaurantsList(Model model, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if(utilisateur.isPresent()) {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            model.addAttribute("currentUser", utilisateur.orElse(null));
            model.addAttribute("restaurants", restaurants);

        }
        System.out.println("utilisateur :" + utilisateur.get());
        return "restaurants-list";
    }

    @GetMapping("/restaurants/list/{id}")
    public String getUserRestaurants(@PathVariable("id") Long utilisateurId, Model model, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(utilisateurId);
        if (utilisateur.isPresent()) {
            List<Restaurant> restaurants = utilisateur.get().getRestaurants();
            model.addAttribute("restaurants", restaurants);
            model.addAttribute("currentUser", utilisateur.get());
        } else {
            System.out.println("Utilisateur non trouvé pour l'ID : " + utilisateurId);
            return "redirect:/error";
        }
        System.out.println("Utilisateur actuel : " + authentication.getPrincipal());
        return "restaurants-list-user";
    }


    @PostMapping("/add")
    public String addRestaurantToUser(@RequestParam Long restaurantId, Authentication authentication) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(restaurantId);

        if (utilisateur.isPresent() && restaurant.isPresent()) {
            utilisateurService.addRestaurantToUser(utilisateur.get(), restaurant.get());
        }
        return "redirect:/restaurants/add";
    }
}
