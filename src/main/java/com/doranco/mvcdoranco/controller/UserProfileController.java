package com.doranco.mvcdoranco.controller;


import com.doranco.mvcdoranco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{username}")
    public String viewProfile(@PathVariable String username, Model model) {
        Map<String, String> user = userService.getUser(username);
        if (user != null) {
            model.addAttribute("user", user);
            return "profile"; // Nom de la vue Thymeleaf
        } else {
            return "no-profile"; // Nom de la vue pour utilisateur non trouvé
        }
    }
}
