package com.example.demo.service.impl;

import com.example.demo.dto.UserConducteurDTO;
import com.example.demo.repository.ConducteurRepository;
import com.example.demo.repository.TypeuserRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class ConducteurServiceImpl implements ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeuserRepository typeuserRepository;


    @Override
    public List<UserConducteurDTO> getAllConducteurs() {
        return conducteurRepository.getAllConducteurs();
    }

    @Override
    public List<UserConducteurDTO> getConducteurByname(String nom) {
        return conducteurRepository.getConducteurByname(nom);
    }

    @Override
    @Transactional
    public void addConducteur (String nom, String email, String pass, String tel, String typeUser, String permis, Boolean dispo, int exp) {
        int idtypeuser= typeuserRepository.findTypeUserIdByName(typeUser);
        
        // 1. Création du User
        userRepository.addUser(nom, email, pass, tel, idtypeuser);

        // 2. Récupération de l'id du dernier User inséré (si pas de retour direct via la méthode d'insert)
        int iduser = userRepository.getDernierUserCree(); // il faut faire cette méthode dans le repo

        // 3. Création du Conducteur lié à ce User
        conducteurRepository.addConducteur(iduser, permis, dispo, exp);
    }

    @Override
    public void updateConducteur(int id, String nom, String email, String pass, String tel, String typeUser, String permis, Boolean dispo, int exp) {
        userRepository.updateUser(id, nom, email, pass, tel, id);
        conducteurRepository.updateConducteur(id, permis, dispo, exp);
    }

    @Override
    public void deleteConducteur(int id) {
        conducteurRepository.deleteConducteur(id);
        userRepository.deleteUser(id);
    }

    @Override
    public int countConducteurs() {
        
        return conducteurRepository.countConducteurs();
    }
}