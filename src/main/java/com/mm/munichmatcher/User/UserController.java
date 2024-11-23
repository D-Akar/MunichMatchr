package com.mm.munichmatcher.User;

import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageLatLng;
import com.opencagedata.jopencage.model.JOpenCageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{email}/{password}")
    public int loginVerification(@PathVariable String email, @PathVariable String password) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return 0;
        }
        if (user.getPassword().equals(password)) {
            return 1;
        }
        return 0;
    }

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{email}")
    public User getUserById(@PathVariable String email, String address) {
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
