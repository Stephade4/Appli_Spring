package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Abonnement;
import com.example.demo.repository.AbonnementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    // public Optional<Abonnement> getAbonnementById(Long id) {
    //     return abonnementRepository.findById(id);
    // }

    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    // public Abonnement updateAbonnement(Long id, Abonnement abonnement) {
    //     if (abonnementRepository.existsById(id)) {
    //         abonnement.setIdAbonnement(id);
    //         return abonnementRepository.save(abonnement);
    //     }
    //     return null;
    // }

    // public void deleteAbonnement(Long id) {
    //     abonnementRepository.deleteById(id);
    // }
}