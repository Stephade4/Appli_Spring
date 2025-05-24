package com.example.demo.dto;

import com.example.demo.model.Admin;
import com.example.demo.model.User;

public class UserAdminDTO {

     User user;
     Admin admin;

    public UserAdminDTO(User user, Admin admin){
        this.user= user;
        this.admin= admin;
    }
    
}
