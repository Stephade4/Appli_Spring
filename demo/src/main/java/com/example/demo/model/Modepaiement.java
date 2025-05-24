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
@Table(name="modepaiement")
public class Modepaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmode;

    @Column(name="type_mode",nullable = false, length=255)
    String typemode;

    @OneToMany(mappedBy = "modepaie", cascade = CascadeType.ALL)
    private List<Paiement> listpaie;

    public Modepaiement(){}

    //get id 
    public int getId(){
        return idmode;
    }

    //get et set typemode
    public String gettype(){
        return typemode;
    }
    public void settype(String type){
        this.typemode=type;
    }
}
