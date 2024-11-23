package com.mm.munichmatcher.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{email}")
    public User getUserById(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

}
