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
@Table(name="classtrajet")
public class ClassTrajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idclass;
    
    @Column(name = "libelle",nullable=false, length = 255)
    private String libelle;

    @OneToMany(mappedBy = "classTrajet", cascade = CascadeType.ALL)
    private List<Trajet> listrajet;

    public ClassTrajet() {}

    //getter et setter
    public String getlibelle(){
        return libelle;
    }
    public void setlibelle(String libelle){
        this.libelle= libelle;
    }

    //get id
    public int getid(){
        return idclass;
    }
} 
