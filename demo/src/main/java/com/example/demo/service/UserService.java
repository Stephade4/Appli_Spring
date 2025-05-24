package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(String nom, String email, String pass, String tel, String typeUserId);
    void updateUser(int id, String nom, String email, String pass, String tel, String typeUser);
    void deleteUser(int id);
    int countUsers();
}