package com.example.demo.service.impl;

import com.example.demo.dto.TrajetClassDTO;
import com.example.demo.dto.compteTrajetDTO;
import com.example.demo.repository.ClasstrajetRepository;
import com.example.demo.repository.TrajetRepository;
import com.example.demo.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrajetServiceImpl implements TrajetService {

    @Autowired
    private TrajetRepository trajetRepository;
    private ClasstrajetRepository classrepository;

    @Override
    public void ajouterTrajet(String ville_depart, String ville_arrive, Double distance, Double tarif, String statut, int id_class) {
        trajetRepository.addTrajet(ville_depart, ville_arrive, distance, tarif, statut, id_class);
    }

    @Override
    public void modifierTrajet(int id, String villeDepart, String villeArrivee, Double distance, Double tarif, String statut, int idclass) {
        trajetRepository.updateTrajet(id, villeDepart, villeArrivee, distance, tarif, statut, idclass);
    }

    @Override
    public void supprimerTrajet(int id) {
        trajetRepository.deleteTrajet(id);
    }

    @Override
    public List<TrajetClassDTO> rechercherTrajet(String villeDepart){
        return trajetRepository.rechercherParVille(villeDepart);
    }

    @Override
    public compteTrajetDTO compterTrajets() {
        return trajetRepository.countTrajets();
    }

    @Override
    public List<TrajetClassDTO> listerTrajets() {
        return trajetRepository.listerTrajets();
    }

    @Override
    public TrajetClassDTO rechercherParId(int id) {
        return trajetRepository.rechercherParId(id);
    }
}