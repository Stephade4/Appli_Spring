package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicule;
import com.example.demo.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {

    // @Autowired
    // private VehiculeRepository vehiculeRepository;

    // public List<Vehicule> getAllVehicules() {
    //     return vehiculeRepository.findAll();
    // }

    // public Optional<Vehicule> getVehiculeById(Long id) {
    //     return vehiculeRepository.findById(id);
    // }

    // public Vehicule createVehicule(Vehicule vehicule) {
    //     return vehiculeRepository.save(vehicule);
    // }

    // public Vehicule updateVehicule(Long id, Vehicule vehicule) {
    //     if (vehiculeRepository.existsById(id)) {
    //         vehicule.setIdVehicule(id);
    //         return vehiculeRepository.save(vehicule);
    //     }
    //     return null;
    // }

    // public void deleteVehicule(Long id) {
    //     vehiculeRepository.deleteById(id);
    // }
}
