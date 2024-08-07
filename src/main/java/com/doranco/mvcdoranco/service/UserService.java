package com.doranco.mvcdoranco.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, Map<String, String>> users = new HashMap<>();

    public void addUser(String username, String firstName, String lastName, String birthDate, String profilePicture) {
        Map<String, String> userAttributes = new HashMap<>();
        userAttributes.put("username", username);
        userAttributes.put("firstname", firstName);
        userAttributes.put("lastname", lastName);
        userAttributes.put("birthDate", birthDate);
        userAttributes.put("profilePicture", profilePicture);
        users.put(username, userAttributes);
    }

    public Map<String, String> getUser(String username) {
        return users.get(username);
    }
}
