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
@Table(name="vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idvehicul;

    @Column(name="immatriculation",nullable = false,length=255)
    String matricul;

    @Column(name="modele_veh", nullable = false,length=255)
    String model;

    @Column(name="marque_veh", nullable=false,length=255)
    String marque;

    @Column(name = "capacite_place", nullable = false, length=255)
    String capacite;

    @Column(name="Statut", nullable = false)
    Boolean statut;

    @OneToMany(mappedBy = "vehicul", cascade = CascadeType.ALL)
    private List<AffecterVehicul> affectation;

    public Vehicule(){}

    //get id
    public int getId(){
        return idvehicul;
    }

    //get et set matricule
    public String getmatri(){
        return matricul;
    }
    public void setmatri(String mat){
        this.matricul=mat;
    }

    //get et set model
    public String getmodel(){
        return model;
    }
    public void setmodel(String mode){
        this.matricul=mode;
    }

    //get et set marque
    public String getmaque(){
        return marque;
    }
    public void setmarque(String mark){
        this.marque=mark;
    }

    //get et set capacite
    public String getcap(){
        return capacite;
    }
    public void setcap(String cap){
        this.capacite=cap;
    }

    //get et set statut
    public Boolean getstat(){
        return statut;
    }
    public void setstat(Boolean sta){
        this.statut=sta;
    }
}
