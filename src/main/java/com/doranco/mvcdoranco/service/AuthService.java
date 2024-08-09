package com.doranco.mvcdoranco.service;

import com.doranco.mvcdoranco.model.Author;
import com.doranco.mvcdoranco.data.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Optional<Author> authenticate(String email, String password) {
        Optional<Author> author = authorDAO.findByEmail(email);
        if (author.isPresent() && author.get().getPassword().equals(password)) {
            return author; // L'utilisateur est authentifié
        }
        return Optional.empty(); // L'authentification a échoué
    }

    public boolean isEmailRegistered(String email) {
        return authorDAO.findByEmail(email).isPresent();
    }
}
