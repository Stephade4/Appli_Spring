package com.example.demo.model;

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
@Table(name="affectervehicul")
public class AffecterVehicul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idaffecte;

    @Column(name="debut_aff", nullable=false)
    LocalDate debut_aff;

    @Column(name="fin_aff", nullable=false)
    LocalDate fin_aff;

    @ManyToOne
    @JoinColumn(name = "vehicul_id", referencedColumnName = "idvehicul")
    private Vehicule vehicul;

    @OneToMany(mappedBy = "vehiculAff", cascade = CascadeType.ALL)
    List<AssignerTrajet> trajetAssigner;

    public AffecterVehicul(){}

    //getid
    public int getId(){
        return idaffecte;
    }

    //getter et setter de debut affecter
    public LocalDate getDebutAff(){
        return debut_aff;
    }
    public void setDebutAff(LocalDate dat){
        this.debut_aff=dat;
    }

    //getter et setter de fin affecter
    public LocalDate getFinAff(){
        return fin_aff;
    }
    public void setFinAff(LocalDate dat){
        this.fin_aff=dat;
    }
    
}
