package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.TestSecurityConfig;
import com.doranco.mvcdoranco.controller.UserProfileController;
import com.doranco.mvcdoranco.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(UserProfileController.class)
@Import(TestSecurityConfig.class)
public class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithUserDetails("jdoe")
    public void testViewProfileUserFound() throws Exception {
        // Crée un utilisateur fictif
        Map<String, String> mockUser = new HashMap<>();
        mockUser.put("username", "jdoe");
        mockUser.put("firstName", "John");
        mockUser.put("lastName", "Doe");
        mockUser.put("birthDate", "1990-01-01");
        mockUser.put("profilePicture", "/images/jdoe.png");

        // Simule le comportement du service utilisateur
        when(userService.getUser("jdoe")).thenReturn(mockUser);

        // Effectue une requête GET et vérifie la réponse
        mockMvc.perform(get("/profile/jdoe"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", mockUser));
    }

    /*@Test
    @WithUserDetails("manager")
    public void testViewProfileUserNotFound() throws Exception {
        // Simule le comportement du service utilisateur pour un utilisateur non trouvé
        when(userService.getUser("nonexistent")).thenReturn(null);

        // Effectue une requête GET et vérifie la réponse
        mockMvc.perform(get("/profile/nonexistent"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-not-found"));
    }*/
}
