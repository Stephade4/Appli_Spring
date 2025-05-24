package com.example.demo.service;

import com.example.demo.model.TypeUser;

import java.util.List;

public interface TypeuserService {

    void ajouterTypeUser(String libelleType);

    void modifierTypeUser(int id, String libelleType);

    void supprimerTypeUser(int id);

    List<TypeUser> listerTypeUsers();

    TypeUser rechercherParId(int id);

    int compterTypeUsers();

    int rechercheIdParNom(String libelle);
}