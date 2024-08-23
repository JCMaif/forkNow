package com.simplon.forknow.controller;

import com.simplon.forknow.dto.RestaurantDto;
import com.simplon.forknow.model.Cuisine;
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
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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


    @GetMapping("/restaurants/add")
    public String addRestaurantToUser(@RequestParam Long restaurantId, Authentication authentication, Model model) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(restaurantId);

        if (utilisateur.isPresent() && restaurant.isPresent()) {
            utilisateurService.addRestaurantToUser(utilisateur.get(), restaurant.get());
        } else {
            model.addAttribute("error", "Unable to add restaurant.");
        }

        return "redirect:/restaurants/list/" + utilisateur.get().getId();
    }

    @GetMapping("/restaurants/remove")
    public String removeRestaurantFromUser(@RequestParam Long restaurantId, Authentication authentication, Model model) {
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(restaurantId);

        if (utilisateur.isPresent() && restaurant.isPresent()) {
            utilisateurService.removeRestaurantFromUser(utilisateur.get(), restaurant.get());
        } else {
            model.addAttribute("error", "Unable to remove restaurant.");
        }

        return "redirect:/restaurants/list/" + utilisateur.get().getId();
    }

    @GetMapping("/restaurants/create")
    public String createRestaurantForm(Model model){
        Restaurant restaurant = new Restaurant();
        List<Cuisine> cuisines = cuisineService.findAllCuisines();
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("cuisines", cuisines);
        return "restaurants-create";
    }

    @PostMapping("/restaurants/create")
    public String createRestaurant(@ModelAttribute RestaurantDto restaurantDto, Authentication authentication, Model model){
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        if (utilisateur.isPresent()) {

            List<Cuisine> selectedCuisines = restaurantDto.getCuisines()
                    .stream()
                    .map(cuisineId -> cuisineService.findById(cuisineId).orElse(null))
                    .filter(Objects::nonNull)
                    .toList();

            Restaurant restoEntity = Restaurant.builder()
                            .name(restaurantDto.getName())
                            .imageName(restaurantDto.getImageName())
                            .cuisines(selectedCuisines)
                            .build();

            restaurantService.saveRestaurant(restoEntity);
            utilisateurService.addRestaurantToUser(utilisateur.get(), restoEntity);
            return "redirect:/restaurants/list/" + utilisateur.get().getId();
        } else {
            model.addAttribute("error", "Unable to create restaurant.");
            return "restaurants-create";
        }

    }

    @DeleteMapping("/restaurants/delete")
    public String deleteRestaurant(@ModelAttribute Long restaurantId, Authentication authentication, Model model){
        Optional<Utilisateur> utilisateur = utilisateurService.from(authentication);
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(restaurantId);

        if(utilisateur.isPresent() && restaurant.isPresent()){
            restaurantService.deleteRestaurant(restaurant.get().getId());
        }
        return "redirect:/restaurants/list/" + utilisateur.get().getId();
    }

}
