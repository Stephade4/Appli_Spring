package com.example.demo.service;

import com.example.demo.model.ClassTrajet;

import java.util.List;

public interface ClassTrajetService {
    void addClassTrajet(String libelle);
    void updateClassTrajet(int id, String libelle);
    void deleteClassTrajet(int id);
    List<ClassTrajet> getAllClassTrajets();
    String getClassTrajetByid(int id);
    int countClassTrajets();
}