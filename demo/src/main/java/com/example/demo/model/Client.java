package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client {
    
    @Id
    String numcni;

    @Column(name="profession", nullable = false, length=255)
    String metier;

    public Client(){}

    //get et set num
    public String getnumcni(){
        return numcni;
    }
    public void setnumcni(String num){
        this.numcni=num;
    }

    //get et set metier
    public String getmetier(){
        return metier;
    }
    public void setmetier(String met){
        this.metier=met;
    }

    @OneToMany(mappedBy = "clientB", cascade = CascadeType.ALL)
    private List<Bagage> bagages;

    @OneToMany(mappedBy = "clientso", cascade = CascadeType.ALL)
    private List<Souscrire> souscriplist;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Reservation> listreserve;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
}