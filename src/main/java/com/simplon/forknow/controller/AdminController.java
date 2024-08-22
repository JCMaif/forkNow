package com.simplon.forknow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

//    private final AuthenticationManager authenticationManager;
//    private final UtilisateurService utilisateurService;
//
//    @Autowired
//    public AdminController(AuthenticationManager authenticationManager, UtilisateurService utilisateurService) {
//        this.authenticationManager = authenticationManager;
//        this.utilisateurService = utilisateurService;
//    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

//
}
