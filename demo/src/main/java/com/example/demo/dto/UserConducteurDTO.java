package com.example.demo.dto;

import com.example.demo.model.User;

public class UserConducteurDTO {

    User user;
    String permi;
    Boolean dispo;
    int exp;

    public UserConducteurDTO(User user, String permi, Boolean dispo, int exp){
        this.permi=permi;
        this.user= user;
        this.dispo=dispo;
        this.exp=exp;
    }
    
}
