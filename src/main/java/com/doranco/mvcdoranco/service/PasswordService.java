package com.doranco.mvcdoranco.service;

public interface PasswordService {
    String hashPassword(String password);
    boolean verifyPassword(String rawPassword, String hashedPassword);
}
