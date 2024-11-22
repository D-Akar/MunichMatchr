package com.mm.munichmatcher.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }


}
