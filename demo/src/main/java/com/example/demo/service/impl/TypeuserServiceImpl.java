package com.example.demo.service.impl;

import com.example.demo.model.TypeUser;
import com.example.demo.repository.TypeuserRepository;
import com.example.demo.service.TypeuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeuserServiceImpl implements TypeuserService {

    @Autowired
    private TypeuserRepository typeUserRepository;

    @Override
    public void ajouterTypeUser(String libelleType) {
        typeUserRepository.ajouterTypeUser(libelleType);
    }

    @Override
    public void modifierTypeUser(int id, String libelleType) {
        typeUserRepository.modifierTypeUser(id, libelleType);
    }

    @Override
    public void supprimerTypeUser(int id) {
        typeUserRepository.supprimerTypeUser(id);
    }

    @Override
    public List<TypeUser> listerTypeUsers() {
        return typeUserRepository.listerTypeUsers();
    }

    @Override
    public TypeUser rechercherParId(int id) {
        return typeUserRepository.rechercherParId(id);
    }

    @Override
    public int rechercheIdParNom(String nom) {
        return typeUserRepository.findTypeUserIdByName(nom);
    }

    @Override
    public int compterTypeUsers() {
        return typeUserRepository.compterTypeUsers();
    }
}