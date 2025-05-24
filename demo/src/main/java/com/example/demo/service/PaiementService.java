package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.controller.PaiementController;
import com.example.demo.model.Paiement;
import com.example.demo.repository.ModePaiementRepository;
import com.example.demo.repository.PaiementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private ModePaiementRepository modePaiementRepository; // Injecter le repository de ModePaiement

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    // public Optional<PaiementController> getPaiementById(Long id) {
    //     return Optional.empty();
    // }

    // public Paiement createPaiement(Paiement paiement, Long idModePaiement) {
    //     return (Paiement) modePaiementRepository.findById(idModePaiement)
    //             .map(mode -> {
    //                 paiement.setModePaiement(mode);
    //                 return paiementRepository.save(paiement);
    //             })
    //             .orElse(null); // Gérer le cas où le mode de paiement n'existe pas
    // }

    // public Paiement updatePaiement(Long id, Paiement paiement, Long idModePaiement) {
    //     return paiementRepository.findById(id)
    //             .map(existingPaiement -> {
    //                 return modePaiementRepository.findById(idModePaiement)
    //                         .map(mode -> {
    //                             existingPaiement.setMontant(paiement.getMontant());
    //                             existingPaiement.setDatePaiement(paiement.getDatePaiement());
    //                             existingPaiement.setModePaiement(mode);
    //                             return paiementRepository.save(existingPaiement);
    //                         })
    //                         .orElse(null); // Gérer le cas où le mode de paiement n'existe pas
    //             })
    //             .orElse(null); // Gérer le cas où le paiement n'existe pas
    // }

    // public void deletePaiement(Long id) {
    //     paiementRepository.deleteById(id);
    // }
}