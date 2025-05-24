package com.example.demo.model;

import java.sql.Time;
import java.time.LocalDate;
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
@Table(name="assignertrajet")
public class AssignerTrajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idasign;
 
    @Column(name="date_depart",nullable=false)
    LocalDate depart;

    @Column(name="heure_depart", nullable=false)
    Time heure_debut;

    @Column(name="date_arrive",nullable=false)
    LocalDate arrive;

    @Column(name="heure_arrive", nullable=false)
    Time heure_arrive;
    
    @ManyToOne
    @JoinColumn(name = "trajet_id", referencedColumnName = "idtrajet")
    private Trajet trajectoire;

    @OneToMany(mappedBy = "trajetreserve", cascade = CascadeType.ALL)
    private List<Reservation> listreserve;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "con_id", referencedColumnName = "idcon")
    private Conducteur chauffeur;

    @ManyToOne
    @JoinColumn(name = "AffecteVehicul_id", referencedColumnName = "idaffecte")
    private AffecterVehicul vehiculAff;

    public AssignerTrajet(){}

    //getter et setter
    public int getid(){
        return idasign;
    }

    //get et heure depart
    public Time getdeparttime(){
        return heure_debut;
    }
    public void setdeparttime(Time htime){
        this.heure_debut= htime;
    }

    //get et heure arrive
    public Time getarrivetime(){
        return heure_arrive;
    }
    public void setarrivetime(Time htime){
        this.heure_arrive= htime;
    }

    //getter et setter
    public LocalDate getdepart(){
        return depart;
    }
    public void setdepart(LocalDate debut){
        this.depart= debut;
    }

    public LocalDate getarrive(){
        return arrive;
    }
    public void setarrive(LocalDate fin){
        this.arrive= fin;
    }
}
