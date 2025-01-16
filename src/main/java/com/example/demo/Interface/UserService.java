package com.example.demo.Interface;

import com.example.demo.entity.User;

public interface UserService {
    User authenticateUser(String username, String password);
    User findByUsername(String username);
    User saveUser(User user);
}

