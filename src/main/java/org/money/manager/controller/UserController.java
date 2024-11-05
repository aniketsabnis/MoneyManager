package org.money.manager.controller;

import org.money.manager.model.AppUser;
import org.money.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AppUser appUser) {
        // Check if the email (username) is already registered
        if (userRepository.findByEmail(appUser.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists.");
        }

        // Encrypt the password before saving it
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        // Save the user in the database
        userRepository.save(appUser);

        return ResponseEntity.ok("User registered successfully.");
    }
}
