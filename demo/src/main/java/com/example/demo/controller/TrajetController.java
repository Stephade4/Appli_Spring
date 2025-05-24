package com.example.demo.controller;

import com.example.demo.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.dto.TrajetClassDTO;
import com.example.demo.dto.compteTrajetDTO;

@RestController
@RequestMapping("/api/trajet")
public class TrajetController {

    @Autowired
    private TrajetService trajetService;

    @PostMapping("/add")
    public String addTrajet(@RequestParam("ville_depart") String ville_depart,
                            @RequestParam("ville_arrive") String ville_arrive,
                            @RequestParam("distance") Double distance,
                            @RequestParam("tarif") Double tarif,
                            @RequestParam("statut") String statut,
                            @RequestParam("id_class") int id_class) {
        trajetService.ajouterTrajet(ville_depart, ville_arrive, distance, tarif, statut, id_class);
        return "Trajet ajouté avec succès";
    }

    @PutMapping("/update/{id}")
    public String updateTrajet(@PathVariable int id,
                               @RequestParam("villeDepart") String villeDepart,
                               @RequestParam("villeArrivee") String villeArrivee,
                               @RequestParam("distance") double distance,
                               @RequestParam("tarif") double tarif,
                               @RequestParam("statut") String statut,
                               @RequestParam("idclass") int idclass) {
        trajetService.modifierTrajet(id, villeDepart, villeArrivee, distance, tarif, statut, idclass);
        return "Trajet mis à jour avec succès";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTrajet(@PathVariable int id) {
        trajetService.supprimerTrajet(id);
        return "Trajet supprimé avec succès";
    }

    @GetMapping("/all")
    public List<TrajetClassDTO> getAllTrajets() {
        return trajetService.listerTrajets();
    }

    @GetMapping("/count")
    public compteTrajetDTO countTrajets() {
        return trajetService.compterTrajets();
    }

    @GetMapping("/find/{id}")
    public TrajetClassDTO findTrajetById(@PathVariable int id) {
        return trajetService.rechercherParId(id);
    }

    @GetMapping("/search")
    public List<TrajetClassDTO> findTrajetsByVilleDepart(@RequestParam String villeDepart) {
        return trajetService.rechercherTrajet(villeDepart);
    }
}