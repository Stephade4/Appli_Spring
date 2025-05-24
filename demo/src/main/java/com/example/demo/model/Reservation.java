package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idreserve;

    @Column(name="nbre_place",nullable = false)
    int nbr_place;

    @Column(name="num_siege",nullable = false)
    int num_siege;

    @Column(name="statut_reserve",nullable = false,length=255)
    String statut;

    public Reservation(){}

    //get id
    public int getId(){
        return idreserve;
    }

    //get et set nbre
    public int getnbrepl(){
        return nbr_place;
    }
    public void setnbre(int nbre){
        this.nbr_place=nbre;
    }

    //get et set num
    public int getnum(){
        return num_siege;
    }
    public void setnum(int num){
        this.num_siege=num;
    }

    //get et set statut
    public String getstatut(){
        return statut;
    }
    public void setstatut(String stat){
        this.statut=stat;
    }

    @ManyToOne
    @JoinColumn(name = "trajetasign_id", referencedColumnName = "idasign")
    private AssignerTrajet trajetreserve;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "numcni")
    private Client client;
    
}
