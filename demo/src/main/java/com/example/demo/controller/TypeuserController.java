package com.example.demo.controller;

import com.example.demo.model.TypeUser;
import com.example.demo.service.TypeuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/typeuser")
public class TypeuserController {

    @Autowired
    private TypeuserService typeUserService;

    @PostMapping("/add")
    public String addTypeUser(@RequestParam String libelleType) {
        typeUserService.ajouterTypeUser(libelleType);
        return "TypeUser ajouté avec succès";
    }

    @PutMapping("/update/{id}")
    public String updateTypeUser(@PathVariable int id, @RequestParam String libelleType) {
        typeUserService.modifierTypeUser(id, libelleType);
        return "TypeUser mis à jour avec succès";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTypeUser(@PathVariable int id) {
        typeUserService.supprimerTypeUser(id);
        return "TypeUser supprimé avec succès";
    }

    @GetMapping("/all")
    public List<TypeUser> getAllTypeUsers() {
        return typeUserService.listerTypeUsers();
    }

    @GetMapping("/count")
    public long countTypeUsers() {
        return typeUserService.compterTypeUsers();
    }

    @GetMapping("/find/{id}")
    public TypeUser findTypeUserById(@PathVariable int id) {
        return typeUserService.rechercherParId(id);
    }

    // @GetMapping("/search")
    // public List<TypeUser> findTypeUsersByLibelle(@RequestParam String libelleType) {
    //     return typeUserService.rechercheIdParNom(libelleType);
    // }
}