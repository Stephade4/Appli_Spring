package com.example.demo.service.impl;

import com.example.demo.dto.UserAdminDTO;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.TypeuserRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TypeuserRepository typeuserRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addAdmin(String nom, String email, String password, String telephone, String typeuser, String post) {
        int idtypeuser= typeuserRepository.findTypeUserIdByName(typeuser);
        // Étape 1 : création du user
        userRepository.addUser(nom, email, password, telephone, idtypeuser);

        // Étape 2 : récupérer le dernier id inséré
        int idUser = userRepository.getDernierUserCree();

        // Étape 3 : insérer cet id dans admin
        adminRepository.addAdmin(post, idUser);
    }

    public void updateAdmin(int id, String nom,String email,String motDePasse,String telephone,String typeuser,String post){
        int idtypeuser= typeuserRepository.findTypeUserIdByName(typeuser);

        userRepository.updateUser(id, nom, email, motDePasse, telephone, idtypeuser);
        int idUser = userRepository.getDernierUserCree();
        adminRepository.updateAdmin(post, idUser);
    }

    @Override
    public void deleteAdmin(int idAdmin) {
        adminRepository.deleteAdmin(idAdmin);
        userRepository.deleteUser(idAdmin);
    }

    @Override
    public List<UserAdminDTO> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    @Override
    public UserAdminDTO getAdminByUserNom(String nom) {
        return adminRepository.getAdminByUserNom(nom);
    }

    @Override
    public int countAdmins() {
        return adminRepository.countAdmins();
    }
}