package com.example.demo.dto;

public class TrajetClassDTO {

    String ville_depart;
    String ville_arrive;
    Double distance;
    double tarif;
    String statut;
    private String classtrajet;

    public TrajetClassDTO(String vildepart,String vilarrive,Double distance,double tarif,String statut, String classtrajet){
        this.ville_arrive= vilarrive;
        this.ville_depart=vildepart;
        this.tarif=tarif;
        this.distance=distance;
        this.statut=statut;
        this.classtrajet= classtrajet;
    }

    public String getClassTrajet(){
        return classtrajet;
    }

    public void setClassTrajet(String trajet){
        this.classtrajet= trajet;
    }

    public String getvildepart(){
        return ville_depart;
    }

    public void setvildepart(String trajet){
        this.ville_depart= trajet;
    }

    public String getvilarrive(){
        return ville_arrive;
    }

    public void setvilarrive(String trajet){
        this.ville_arrive= trajet;
    }

    public String getstatut(){
        return statut;
    }

    public void setstatut(String trajet){
        this.statut= trajet;
    }

    public Double getdistance(){
        return distance;
    }

    public void setdistance(Double trajet){
        this.distance= trajet;
    }

    public Double gettarif(){
        return tarif;
    }

    public void settarif(Double trajet){
        this.tarif= trajet;
    }
}
