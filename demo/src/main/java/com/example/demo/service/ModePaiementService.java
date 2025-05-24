package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Modepaiement;
import com.example.demo.repository.ModePaiementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModePaiementService {

    @Autowired
    private ModePaiementRepository modePaiementRepository;

    public List<Modepaiement> getAllModesPaiement() {
        return modePaiementRepository.findAll();
    }

    public Optional<Modepaiement> getModePaiementById(int id) {
        return modePaiementRepository.findById(id);
    }

    public Modepaiement createModePaiement(Modepaiement modePaiement) {
        return modePaiementRepository.save(modePaiement);
    }

    public Modepaiement updateModePaiement(int id, Modepaiement modePaiement) {
        if (modePaiementRepository.existsById(id)) {
            //modePaiement.setIdmode(id);
            return modePaiementRepository.save(modePaiement);
        }
        return null;
    }

    public void deleteModepaiement(int id) {
        modePaiementRepository.deleteById(id);
    }
}
