package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="souscrire")
public class Souscrire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idsouscrit;

    @Column(name="date_souscrit", nullable=false)
    LocalDate date_souscrit;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "numcni")
    private Client clientso;

    @ManyToOne
    @JoinColumn(name = "abonne_id", referencedColumnName = "idAbonne")
    private Abonnement Abonner;

    public Souscrire(){}

    //get id
    public int getId(){
        return idsouscrit;
    }

    //get date
    public LocalDate getdate(){
        return date_souscrit;
    }
    
}
