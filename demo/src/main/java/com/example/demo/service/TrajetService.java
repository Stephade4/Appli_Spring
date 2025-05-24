package com.example.demo.service;

import com.example.demo.dto.TrajetClassDTO;
import com.example.demo.dto.compteTrajetDTO;

import java.util.List;

public interface TrajetService {

    void ajouterTrajet(String ville_depart, String ville_arrive, Double distance, Double tarif, String statut, int id_class);

    void modifierTrajet(int id, String ville_depart, String ville_arrive, Double distance, Double tarif, String statut, int id_class);

    void supprimerTrajet(int id);

    compteTrajetDTO compterTrajets();

    List<TrajetClassDTO> listerTrajets();

    TrajetClassDTO rechercherParId(int id);

    List<TrajetClassDTO> rechercherTrajet(String villeDepart);
}