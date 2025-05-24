package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.TypeuserRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private TypeuserRepository typeuserRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void addUser(String nom, String email, String pass, String tel, String typeUser) {
        
        int idTypeUser = typeuserRepository.findTypeUserIdByName(typeUser);

        userRepository.addUser(nom, email, pass, tel, idTypeUser);
    }

    @Override
    public void updateUser(int id, String nom, String email, String pass, String tel, String typeUser) {

        int idTypeUser = typeuserRepository.findTypeUserIdByName(typeUser);

        userRepository.updateUser(id, nom, email, pass, tel, idTypeUser);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }
}