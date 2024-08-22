package com.simplon.forknow.repository;

import com.simplon.forknow.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findUtilisateurByUsername(String username);

    Optional<Utilisateur> findUtilisateurByEmail(String email);
}
