package com.example.demo.services;

import com.example.demo.Interface.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
