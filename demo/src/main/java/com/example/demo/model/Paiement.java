package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="paiement")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpaie;

    @Column(name="montant", nullable=false)
    Double montant;

    @Column(name="date_paie", nullable = false)
    LocalDate datepaie;

    @ManyToOne
    @JoinColumn(name = "mode_id", referencedColumnName = "idmode")
    private Modepaiement modepaie;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "numcni")
    private Client client;

    public Paiement(){}

    //get id
    public int getId(){
        return idpaie;
    }

    //get et set mont
    public Double getmont(){
        return montant;
    }
    public void setmont(Double mont){
        this.montant = mont;
    }

    //get et set date
    public LocalDate getdate(){
        return datepaie;
    }
    public void setdate(LocalDate dat){
        this.datepaie=dat;
    }
}
