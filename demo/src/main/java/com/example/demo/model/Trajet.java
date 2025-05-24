package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="trajet")
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idtrajet;
    
    @Column(name="ville_depart", nullable =false, length= 255)
    String vildepart;

    @Column(name="ville_arrive", nullable =false, length= 255)
    String vilarrive;

    @Column(name="distance", nullable =false)
    Double distance;

    @Column(name="tarif", nullable =false)
    double tarif;

    @Column(name="statut", nullable =false, length= 255)
    String statut;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName= "idclass")
    private ClassTrajet classTrajet;

    @OneToMany(mappedBy = "trajectoire", cascade = CascadeType.ALL)
    List<AssignerTrajet> assignerTrajet;

    

    public Trajet(){}

    //getter et setter
    public String getvildepart(){
        return vildepart;
    }
    public void setvildepart(String vil){
        this.vildepart= vil;
    }

    public int getId(){
        return idtrajet;
    }

    public String getvilarrive(){
        return vilarrive;
    }
    public void setvilarrive(String vil){
        this.vilarrive= vil;
    }

    public Double getdistance(){
        return distance;
    }
    public void setdistance(Double distance){
        this.distance= distance;
    }

    public Double gettarif(){
        return tarif;
    }
    public void settarif(Double tarif){
        this.tarif= tarif;
    }

    public String getstatut(){
        return statut;
    }
    public void setstatut(String statut){
        this.statut= statut;
    }

    public ClassTrajet getClassTrajet(){
        return classTrajet;
    }
    public void setClassTrajet(ClassTrajet classTrajet){
        this.classTrajet= classTrajet;
    }

}
