package com.simplon.forknow.service.impl;

import com.simplon.forknow.dto.LoginDto;
import com.simplon.forknow.dto.SignupDto;
import com.simplon.forknow.model.Restaurant;
import com.simplon.forknow.model.Utilisateur;
import com.simplon.forknow.model.UtilisateurRole;
import com.simplon.forknow.repository.UtilisateurRepository;
import com.simplon.forknow.service.UtilisateurService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {


    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUtilisateur(LoginDto user) {
        Utilisateur userEntity = Utilisateur.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(UtilisateurRole.CUSTOMER)
                .build();
        utilisateurRepository.save(userEntity);
    }

    @Override
    public void saveUtilisateur(SignupDto user) {
        Utilisateur userEntity = Utilisateur.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(UtilisateurRole.CUSTOMER)
                .creation_date(new Date())
                .build();
        utilisateurRepository.save(userEntity);
    }

    @Override
    public Optional<Utilisateur> findByUsername(String username) {
        return utilisateurRepository.findUtilisateurByUsername(username);
    }

    @Override
    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email);
    }


    public Optional<Utilisateur> from(Authentication authentication) {
        if(authentication == null){
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails userDetails)){
            return Optional.empty();
        }

        return utilisateurRepository.findUtilisateurByUsername(userDetails.getUsername());
    }

    @Override
    public void addRestaurantToUser(Utilisateur utilisateur, Restaurant restaurant) {
        utilisateur.getRestaurants().add(restaurant);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Restaurant> getRestaurantsByUser(Utilisateur utilisateur) {
        return utilisateur.getRestaurants();
    }
}
