package com.internship.ws.controller;

import com.internship.ws.dto.LoginDto;
import com.internship.ws.entity.User;
import com.internship.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PostMapping("/save")
    public ResponseEntity<User> userAdd(@RequestBody User user) {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/auth")
    public void handleAuthentication(@RequestBody LoginDto loginDto) {

    }
}
