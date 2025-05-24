package com.example.demo.controller;

import com.example.demo.model.ClassTrajet;
import com.example.demo.service.ClassTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classtrajet")
public class ClasstrajetController {

    @Autowired
    private ClassTrajetService classTrajetService;

    @PostMapping("/add")
    public String addClassTrajet(@RequestParam("libelle") String libelle) {
        classTrajetService.addClassTrajet(libelle);
        return "Classe de trajet ajoutée avec succès";
    }

    @PutMapping("/update/{id}")
    public String updateClassTrajet(@PathVariable int id, @RequestParam("libelle") String libelle) {
        classTrajetService.updateClassTrajet(id, libelle);
        return "Classe de trajet mise à jour avec succès";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClassTrajet(@PathVariable int id) {
        classTrajetService.deleteClassTrajet(id);
        return "Classe de trajet supprimée avec succès";
    }

    @GetMapping("/all")
    public List<ClassTrajet> getAllClassTrajet() {
        return classTrajetService.getAllClassTrajets();
    }

    @GetMapping("/count")
    public long countClassTrajet() {
        return classTrajetService.countClassTrajets();
    }

    @GetMapping("/find/{id}")
    public String getClassTrajetById(@PathVariable int id) {
        return classTrajetService.getClassTrajetByid(id);
    }

}
