package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bagage")
public class Bagage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idbagage;

    @Column(name = "libelle", nullable = false, length=255)
    String libelle;

    @Column(name="poid", nullable = false)
    Double poids;

    @Column(name="volume",nullable = false)
    Double volumes;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "numcni")
    private Client clientB;

    public Bagage(){}

    //getter id
    public int getId(){
        return idbagage;
    }

    //get et set de libelle
    public String getlibelle(){
        return libelle;
    }
    public void setlibelle(String lib){
        this.libelle=lib;
    }

    //get et set de poid
    public Double getpoids(){
        return poids;
    }
    public void setpoids(Double poid){
        this.poids=poid;
    }

    //get et set volume
    public Double getvolume(){
        return volumes;
    }
    public void setvolume(Double vol){
        this.volumes=vol;
    }
}
