package com.example.demo.service.impl;

import com.example.demo.model.ClassTrajet;
import com.example.demo.repository.ClasstrajetRepository;
import com.example.demo.service.ClassTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasstrajetServiceImpl implements ClassTrajetService {

    @Autowired
    private ClasstrajetRepository classTrajetRepository;

    @Override
    public void addClassTrajet(String libelle) {
        classTrajetRepository.addClassTrajet(libelle);
    }

    @Override
    public void updateClassTrajet(int id, String libelle) {
        classTrajetRepository.updateClassTrajet(id, libelle);
    }

    @Override
    public void deleteClassTrajet(int id) {
        classTrajetRepository.deleteClassTrajet(id);
    }

    @Override
    public List<ClassTrajet> getAllClassTrajets() {
        return classTrajetRepository.getAllClassTrajets();
    }

    @Override
    public String getClassTrajetByid(int id) {
        return classTrajetRepository.getClassTrajetByid(id);
    }

    @Override
    public int countClassTrajets() {
        return classTrajetRepository.countClassTrajets();
    }
}