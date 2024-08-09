package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.service.BCryptPasswordService;
import com.doranco.mvcdoranco.service.PasswordService;

public class PasswordServiceTest {
    public static void main(String[] args) {
        PasswordService passwordService = new BCryptPasswordService();

        String rawPassword = "monMotDePasse";

        String hashedPassword = passwordService.hashPassword(rawPassword);
        System.out.println("Mot de passe brut : " + rawPassword);
        System.out.println("Mot de passe haché : " + hashedPassword);

        boolean isPasswordMatch = passwordService.verifyPassword(rawPassword, hashedPassword);
        System.out.println("Les mots de passe correspondent : " + isPasswordMatch);

        boolean isIncorrectPasswordMatch = passwordService.verifyPassword("mauvaisMotDePasse", hashedPassword);
        System.out.println("Les mots de passe correspondent (mauvais mot de passe) : " + isIncorrectPasswordMatch);
    }
}
