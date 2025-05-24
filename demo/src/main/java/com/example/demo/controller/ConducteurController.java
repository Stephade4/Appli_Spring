package com.example.demo.controller;

import com.example.demo.dto.UserConducteurDTO;
import com.example.demo.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conducteurs")
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    // Ajouter un conducteur
    @PostMapping("/add")
    public String addConducteur(
            @RequestParam String nom,
            @RequestParam String pass,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam String permis,
            @RequestParam Boolean dispo,
            @RequestParam int experience,
            @RequestParam String typeUser
    ) {
        conducteurService.addConducteur(nom, email, pass, telephone, typeUser, permis, dispo, experience);
        return "Conducteur ajouté avec succès";
    }

    // Modifier un conducteur
    @PutMapping("/update/{id}")
    public String updateConducteur(
            @PathVariable int id,
            @RequestParam String nom,
            @RequestParam String pass,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam String permis,
            @RequestParam Boolean dispo,
            @RequestParam int experience,
            @RequestParam String typeUser
    ) {
        conducteurService.updateConducteur(id, nom, email, pass, telephone, typeUser, permis, dispo, experience);
        return "Conducteur mis à jour avec succès";
    }

    // Supprimer un conducteur
    @DeleteMapping("/delete/{id}")
    public String deleteConducteur(@PathVariable int id) {
        conducteurService.deleteConducteur(id);
        return "Conducteur supprimé avec succès";
    }

    // Compter le nombre total de conducteurs
    @GetMapping("/count")
    public int countConducteurs() {
        return conducteurService.countConducteurs();
    }

    // Récupérer la liste de tous les conducteurs
    @GetMapping("/all")
    public List<UserConducteurDTO> getAllConducteurs() {
        return conducteurService.getAllConducteurs();
    }

    // Rechercher un conducteur par son nom
    @GetMapping("/search")
    public List<UserConducteurDTO> searchConducteurByNom(@RequestParam String nom) {
        return conducteurService.getConducteurByname(nom);
    }
}