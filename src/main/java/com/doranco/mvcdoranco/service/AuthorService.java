package com.doranco.mvcdoranco.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthorService {

    private Map<String, Map<String, String>> users = new HashMap<>();

    public void addUser(String username, String firstName, String lastName, String dateOfBirth, String email) {
        Map<String, String> userAttributes = new HashMap<>();
        userAttributes.put("username", username);
        userAttributes.put("firstname", firstName);
        userAttributes.put("lastname", lastName);
        userAttributes.put("dateOfBirth", dateOfBirth);
        userAttributes.put("email", email);
        users.put(username, userAttributes);
    }

    public Map<String, String> getUser(String username) {
        return users.get(username);
    }
}
