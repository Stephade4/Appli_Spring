package com.example.demo.service.impl;

import com.example.demo.dto.PlanningConducteurDTO;
import com.example.demo.model.AssignerTrajet;
import com.example.demo.repository.AssignertrajetRepository;
import com.example.demo.repository.TrajetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssignerTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssignertrajetServiceImpl implements AssignerTrajetService {

    @Autowired
    private AssignertrajetRepository assignerTrajetRepository;

    private UserRepository userRepository;

    private TrajetRepository trajetRepository;

    @Override
    public List<AssignerTrajet> getAllAssignments() {
        return assignerTrajetRepository.findAllAssignments();
    }

    @Override
    public AssignerTrajet getAssignmentById(int id) {
        return assignerTrajetRepository.findAssignmentById(id);
    }

    @Override
    public void addAssignment(LocalDate depart, Time Hdepart, LocalDate arrive, Time Harrive, String nomconducteur, String trajetdepart,
                                         String trajetarrive, int AffecteVehicul_id){

        int idConducteur = userRepository.findIdBynom(nomconducteur);
        int idTrajet = trajetRepository.rechercherIdParVille(trajetdepart, trajetarrive);

        assignerTrajetRepository.addassignerTrajet(depart,Hdepart,arrive,Harrive,idConducteur,idTrajet, AffecteVehicul_id);
    }

    @Override
    public void updateAssignment(int id, LocalDate depart, Time Hdepart, LocalDate arrive, Time Harrive, String nomconducteur, String trajetdepart,
                                             String trajetarrive, int AffecteVehicul_id){

        int idConducteur = userRepository.findIdBynom(nomconducteur);
        int idTrajet = trajetRepository.rechercherIdParVille(trajetdepart, trajetarrive);

        assignerTrajetRepository.updateAssignment(id, depart, Hdepart, arrive, Harrive, idConducteur, idTrajet, AffecteVehicul_id);
    }

    @Override
    public void deleteAssignment(int id) {
        assignerTrajetRepository.deleteAssignment(id);
    }

    @Override
    public int countAssignments() {
        return assignerTrajetRepository.countAssignments();
    }

    @Override
    public List<PlanningConducteurDTO> getAssignmentsByConducteur(String nomconducteur) {
        int idconducteur = userRepository.findIdBynom(nomconducteur);
        return assignerTrajetRepository.findAssignmentsByConducteur(idconducteur);
    }

    @Override
    public List<PlanningConducteurDTO> getAssignmentsByTrajet(int idTrajet) {
        return assignerTrajetRepository.findAssignmentsByTrajet(idTrajet);
    }
}