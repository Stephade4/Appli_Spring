package com.example.demo.model;
import java.sql.Date;
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
@Table(name="TypeUser")
public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTypeuser;

    @Column(name= "libelleType", nullable=false, length=255)
    String libelleType;

    @Column(name="date_creation", nullable=false, length=255)
    Date creer;

    @OneToMany(mappedBy = "typeUser",cascade = CascadeType.ALL)
    List<User> user;

    public TypeUser(){}

    //getter et setter
    public String getlibelle(){
        return libelleType;
    }
    public void setlibelle(String libel){
        this.libelleType=libel;
    }

    //get id
    public int getid(){
        return idTypeuser;
    }
}
