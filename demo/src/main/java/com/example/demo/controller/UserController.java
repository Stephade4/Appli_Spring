package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(
        @RequestParam String nom,
        @RequestParam String pass,
        @RequestParam String mail,
        @RequestParam String telephone,
        @RequestParam String typeUser
    ) {
        userService.addUser(nom, mail, pass, telephone, typeUser);
    }

    @PutMapping("/update/{id}")
    public void updateUser(
        @PathVariable int id,
        @RequestParam String nom,
        @RequestParam String pass,
        @RequestParam String mail,
        @RequestParam String telephone,
        @RequestParam String typeUserId
    ) {
        userService.updateUser(id, nom, mail, pass, telephone, typeUserId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/count")
    public int countUser(){
        return userService.countUsers();
    }

    @GetMapping("/all")
    public List<User> allUser(){
        return userService.getAllUsers();
    }
}