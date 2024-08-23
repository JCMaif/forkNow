package com.simplon.forknow.service;

import com.simplon.forknow.dto.LoginDto;
import com.simplon.forknow.dto.SignupDto;
import com.simplon.forknow.model.Restaurant;
import com.simplon.forknow.model.Utilisateur;
import org.springframework.security.core.Authentication;


import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    void saveUtilisateur(LoginDto user);

    void saveUtilisateur(SignupDto user);

    Optional<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> findById(Long id);
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> from(Authentication authentication);

    void addRestaurantToUser(Utilisateur utilisateur, Restaurant restaurant);

    List<Restaurant> getRestaurantsByUser(Utilisateur utilisateur);
}
