package com.example.demo.controller;

import com.example.demo.dto.PlanningConducteurDTO;
import com.example.demo.model.AssignerTrajet;
import com.example.demo.service.AssignerTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/assignertrajet")
public class AssignertrajetController {

    @Autowired
    private AssignerTrajetService assignerTrajetService;

    @PostMapping("/add")
    public String assignerTrajet(
            @RequestParam String villeDepart,
            @RequestParam String villeArrivee,
            @RequestParam String conducteurNom,
            @RequestParam("dateDepart") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate depart,
            @RequestParam Time Hdepart,
            @RequestParam Time Harrive,
            @RequestParam("dateArrive") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate arrivee,
            @RequestParam int affectVehi
    ) {
        // conversion des dates de String à LocalDateTime

        assignerTrajetService.addAssignment( depart, Hdepart, arrivee , Harrive, conducteurNom, villeDepart, villeArrivee, affectVehi);
        return "Trajet assigné avec succès";
    }

    @PutMapping("/update/{id}")
    public String updateAssignment(
            @PathVariable int id,
            @RequestParam String villeDepart,
            @RequestParam String villeArrivee,
            @RequestParam String conducteurNom,
            @RequestParam Time Hdepart,
            @RequestParam Time Harrive,
            @RequestParam("dateDepart") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate depart,
            @RequestParam("dateArrive") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate arrivee,
            @RequestParam int affectVehi
    ) {

        assignerTrajetService.updateAssignment(id,depart,Hdepart, arrivee, Harrive, conducteurNom, villeDepart, villeArrivee, affectVehi);
        return "Assignment mis à jour avec succès";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAssignment(@PathVariable int id) {
        assignerTrajetService.deleteAssignment(id);
        return "Assignment supprimé avec succès";
    }

    @GetMapping("/all")
    public List<AssignerTrajet> getAllAssignments() {
        return assignerTrajetService.getAllAssignments();
    }

    @GetMapping("/count")
    public long countAssignments() {
        return assignerTrajetService.countAssignments();
    }

    @GetMapping("/find/{id}")
    public AssignerTrajet getAssignmentById(@PathVariable int id) {
        return assignerTrajetService.getAssignmentById(id);
    }

    @GetMapping("/search")
    public List<PlanningConducteurDTO> findAssignmentsByConducteurNom(@RequestParam String conducteurNom) {
        return assignerTrajetService.getAssignmentsByConducteur(conducteurNom);
    }
}