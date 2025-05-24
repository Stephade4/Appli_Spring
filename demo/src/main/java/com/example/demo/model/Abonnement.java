package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAbonne;

    @Column(name="type_abonne",nullable = false, length=255)
    String typeAbonne;

    @OneToMany(mappedBy = "Abonner", cascade = CascadeType.ALL)
    private List<Souscrire> souscriplist;

    //constructeur
    public Abonnement(){}
    
    // getter id
    public int getId(){
        return idAbonne;
    }

    //getter et setter type
    public String getTypeAbon(){
        return typeAbonne;
    }
    public void setTypeabon(String type){
        this.typeAbonne=type;
    }
}
