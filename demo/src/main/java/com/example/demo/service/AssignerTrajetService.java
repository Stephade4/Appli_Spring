package com.example.demo.service;

import com.example.demo.dto.PlanningConducteurDTO;
import com.example.demo.model.AssignerTrajet;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface AssignerTrajetService {

    List<AssignerTrajet> getAllAssignments();
    AssignerTrajet getAssignmentById(int id);
    void addAssignment(LocalDate depart, Time Hdepart, LocalDate arrive, Time Harrive, String nomconducteur, String trajetdepart, String trajetarrive, int AffecterVehicul);
    void updateAssignment(int id, LocalDate depart, Time Hdepart, LocalDate arrive, Time Harrive, String nomconducteur, String trajetdepart, String trajetarrive, int AffecterVehicul);
    void deleteAssignment(int id);
    int countAssignments();
    List<PlanningConducteurDTO> getAssignmentsByConducteur(String nomconducteur);
    List<PlanningConducteurDTO> getAssignmentsByTrajet(int idTrajet);
}