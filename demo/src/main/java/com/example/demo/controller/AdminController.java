package com.example.demo.controller;

import com.example.demo.dto.UserAdminDTO;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String addAdmin(@RequestParam String nom, 
                           @RequestParam String email, 
                           @RequestParam String telephone, 
                           @RequestParam String motDePasse, 
                           @RequestParam String typeUser,
                           @RequestParam String post) {
        adminService.addAdmin(nom, email, motDePasse, telephone, typeUser, post);
        return "Admin ajouté avec succès";
    }

    @PutMapping("/update/{id}")
    public String updateAdmin(@PathVariable int id, 
                              @RequestParam String nom, 
                              @RequestParam String email, 
                              @RequestParam String telephone, 
                              @RequestParam String motDePasse,
                              @RequestParam String typeUser,
                              @RequestParam String post) {
        adminService.updateAdmin(id, nom, email, motDePasse, telephone, typeUser, post);
        return "Admin mis à jour avec succès";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return "Admin supprimé avec succès";
    }

    @GetMapping("/all")
    public List<UserAdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/count")
    public int countAdmins() {
        return adminService.countAdmins();
    }

    @GetMapping("/find/{name}")
    public UserAdminDTO getAdminById(@PathVariable String name) {
        return adminService.getAdminByUserNom(name);
    }
}