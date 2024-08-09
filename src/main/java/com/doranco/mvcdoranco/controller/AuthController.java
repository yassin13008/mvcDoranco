package com.doranco.mvcdoranco.controller;

import com.doranco.mvcdoranco.model.Author;
import com.doranco.mvcdoranco.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Optional<Author> authenticatedUser = authService.authenticate(email, password);
        if (authenticatedUser.isPresent()) {
            return ResponseEntity.ok("Connexion réussi");
        } else if (!authService.isEmailRegistered(email)) {
            return ResponseEntity.status(404).body("Email non-reconnu, inscrivez-vous pour poursuivre");
        } else {
            return ResponseEntity.status(401).body("mot de passe erroné");
        }
    }
}
