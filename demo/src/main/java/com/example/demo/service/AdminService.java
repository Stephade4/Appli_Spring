package com.example.demo.service;

import com.example.demo.dto.UserAdminDTO;

import java.util.List;

public interface AdminService {
    void addAdmin(String nom, String email, String password, String telephone, String typeuser, String post);
    void deleteAdmin(int idAdmin);
    List<UserAdminDTO> getAllAdmins();
    UserAdminDTO getAdminByUserNom(String nom);
    int countAdmins();
    void updateAdmin(int id, String nom, String email, String motDePasse, String telephone, String typeUser, String post);
}