package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateUserRequestDto;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDto request) {
        User newUser = userService.createUser(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
