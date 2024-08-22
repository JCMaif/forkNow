package com.simplon.forknow.service;

import com.simplon.forknow.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurSecurityService implements UserDetailsService {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurSecurityService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurService.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Utilisateur inconnu"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .roles(utilisateur.getRole().name())
                .build();
    }
}
