package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddAndGetUser() {
        userService.addUser("jdoe", "John", "Doe", "1990-01-01", "/images/jdoe.png");

        Map<String, String> user = userService.getUser("jdoe");
        assertNotNull(user);
        assertEquals("John", user.get("firstname"));
        assertEquals("Doe", user.get("lastname"));
        assertEquals("1990-01-01", user.get("birthDate"));
        assertEquals("/images/jdoe.png", user.get("profilePicture"));

        System.out.println("Nom d'utilisateur : " + "jdoe");
        System.out.println("Prénom : " + user.get("firstname"));
        System.out.println("Nom : " + user.get("lastname"));
        System.out.println("Date de naissance : " + user.get("birthDate"));
        System.out.println("Photo de profil : " + user.get("profilePicture"));
    }

    @Test
    public void testGetUserNotFound() {
        Map<String, String> user = userService.getUser("nonexistent");
        assertNull(user);
        System.out.println("Utilisateur non trouvé pour le nom d'utilisateur 'nonexistent'");
    }
}