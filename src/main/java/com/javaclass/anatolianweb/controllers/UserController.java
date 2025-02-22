package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Driver;
import com.javaclass.anatolianweb.model.Manager;
import com.javaclass.anatolianweb.model.User;
import com.javaclass.anatolianweb.repos.DriverRepo;
import com.javaclass.anatolianweb.repos.ManagerRepo;
import com.javaclass.anatolianweb.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/allUsers")
    public @ResponseBody Iterable<User> getAll() {
        return userRepository.findAll(); // Read
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // Create
    }

    @PutMapping(value = "/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setLogin(user.getLogin());
        existingUser.setSurname(user.getSurname());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setPhoneNum(user.getPhoneNum());
        // .....I can add later
        return userRepository.save(existingUser); // Update
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(existingUser); // Delete
    }
}

