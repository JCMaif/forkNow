package com.simplon.forknow.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * PasswordGenerator est une classe utilitaire pour générer des mots de passe cryptés en utilisant l'algorithme Bcrypt.
 * Il est utilisé pour générer des mots de passe cryptés qui seront ajoutés à la base de donnée au démarrage du projet, par le script SQL data.sql dans "resources"
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String customerPassword = passwordEncoder.encode("customer");
        String adminPassword = passwordEncoder.encode("admin");

        System.out.println("Customer password : " + customerPassword);
        System.out.println("Admin password : " + adminPassword);

    }
}
