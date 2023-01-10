package com.ardorhoon.bookapi.controller;


import com.ardorhoon.bookapi.model.User;
import com.ardorhoon.bookapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.create(user.getNickname(), user.getName(), user.getEmail(), user.getPassword());
    }

}
