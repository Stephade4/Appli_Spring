package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUser;
    
    @Column(name="nom", nullable =false, length= 255)
    String nom;

    @Column(name="email", nullable = false, length=255)
    String email;

    @Column(name="tel", nullable=false, length=255)
    String tel;

    @Column(name="password", nullable=false, length=255)
    String pwd;

    @Column(name="createdate",nullable=false)
    LocalDate creationDate;

    // constructeur vide
    public User() {

    }

    @ManyToOne
    @JoinColumn(name="typeuser_id",referencedColumnName = "idTypeuser")
    private TypeUser typeUser;

    //getter sur id
    public int getid(){
        return idUser;
    }

    //getter et setter pour les nom
    public String getnom(){
        return nom;
    }
    public void setnom(String nom){
        this.nom= nom;
    }

    //getter et setter pour les telephone
    public String gettel(){
        return tel;
    }
    public void settel(String tel){
        this.tel= tel;
    }
    
    //get et setter pour email
    public String getemail(){
        return email;
    }
    public void setemail(String mail){
        this.email= mail;
    }

    //get et setter pour password
    public String getpwd(){
        return pwd;
    }
    public void setpwd(String pass){
        this.pwd= pass;
    }
    
}