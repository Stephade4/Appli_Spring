package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

import com.example.demo.model.ClassTrajet;
import com.example.demo.model.Trajet;

public class PlanningConducteurDTO {

    Time heure_depart;
    Time heure_arrive;
    Date date_depart;
    Date date_arrive;
    Trajet trajet;
    ClassTrajet classtrajet;

    public PlanningConducteurDTO(Date date_depart, Time hdebut, Date date_arrive, Time hfin, Trajet trajet, ClassTrajet classtrajet){
        this.trajet=trajet;
        this.classtrajet=classtrajet;
        this.date_depart=date_depart;
        this.date_arrive=date_arrive;
        this.heure_depart=hdebut;
        this.heure_arrive=hfin;
    }
    
}
