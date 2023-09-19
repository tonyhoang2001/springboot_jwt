package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.entity.CustomUserDetails;
import com.example.jwtsecurity.entity.User;
import com.example.jwtsecurity.jwt.JwtTokenProvider;
import com.example.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        CustomUserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtTokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

//    @PostMapping
//    public ResponseEntity<?> authenticate(@RequestBody User user){
//        CustomUserDetails userDetails = userService.loadUserByUsername(user.getUsername());
//        String token = jwtTokenProvider.generateToken(userDetails);
//        return ResponseEntity.ok(token);
//    }

}
