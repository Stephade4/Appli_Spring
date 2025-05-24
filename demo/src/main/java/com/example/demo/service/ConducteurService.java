package com.example.demo.service;

import com.example.demo.dto.UserConducteurDTO;
import java.util.List;

public interface ConducteurService {

    List<UserConducteurDTO> getAllConducteurs();
    List<UserConducteurDTO> getConducteurByname(String id);
    void addConducteur(String nom, String email, String pass, String tel, String typeUserId, String permis, Boolean dispo, int exp);
    void updateConducteur(int id, String nom, String email, String pass, String tel, String typeUserId, String permis, Boolean dispo, int exp);
    void deleteConducteur(int id);
    int countConducteurs();
}