package com.mm.munichmatcher.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email); //.orElse(new User("fail", "Fail"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}