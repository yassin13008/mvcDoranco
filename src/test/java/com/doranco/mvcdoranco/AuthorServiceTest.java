package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class AuthorServiceTest {

    private AuthorService authorService;

    @BeforeEach
    public void setUp() {
        authorService = new AuthorService();
    }

    @Test
    public void testAddAndGetUser() {
        authorService.addUser("jdoe", "John", "Doe", "1990-01-01", "john.doe@gmail.com");

        Map<String, String> user = authorService.getUser("jdoe");
        assertNotNull(user);
        assertEquals("John", user.get("firstname"));
        assertEquals("Doe", user.get("lastname"));
        assertEquals("1990-01-01", user.get("birthDate"));
        assertEquals("john.doe@gmail.com", user.get("email"));

        System.out.println("Nom d'utilisateur : " + "jdoe");
        System.out.println("Prénom : " + user.get("firstname"));
        System.out.println("Nom : " + user.get("lastname"));
        System.out.println("Date de naissance : " + user.get("dateOfBirth"));
        System.out.println("Email : " + user.get("email"));
    }

    @Test
    public void testGetUserNotFound() {
        Map<String, String> user = authorService.getUser("nonexistent");
        assertNull(user);
        System.out.println("Utilisateur non trouvé pour le nom d'utilisateur 'nonexistent'");
    }
}