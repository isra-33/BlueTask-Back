package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.services.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public @ResponseBody User register(@RequestBody User newUser) {
        // Check if the username already exists
        if (userService.findByUsername(newUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Hash the password before saving using BCrypt
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);

        // Save the new user
        return userService.saveUser(newUser);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody User loginRequest) {
        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            // Return just the token as a plain text string, not wrapped in JSON
            return jwtUtil.generateToken(user.getUsername());
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

}
