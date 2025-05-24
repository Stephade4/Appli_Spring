package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="conducteur")
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcon;

    @Column(name = "permis", nullable=false, length=255)
    String permi;

    @Column(name = "disponibilite", nullable=false, length=255)
    Boolean dispo;

    @Column(name = "experience", nullable = false, length = 255)
    int exp;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    @OneToMany(mappedBy = "chauffeur", cascade = CascadeType.ALL)
    List<AssignerTrajet> trajetassigner;

    //constructeur
    public Conducteur() {}

    //getters et setters

    public String getpermi(){
        return permi;
    }
    public void setpermi(String num){
        this.permi = num;
    }

    //getid
    public int getid(){
        return idcon;
    }
    
    //get et setter
    public Boolean getdispo(){
        return dispo;
    }
    public void setdispo(Boolean dispo){
        this.dispo = dispo;
    }

    //get et setter
    public int getexp(){
        return exp;
    }
    public void setexp(int expe){
        this.exp = expe;
    }
}
