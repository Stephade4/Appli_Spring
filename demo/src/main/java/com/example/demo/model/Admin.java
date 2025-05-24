package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin{

    public Admin(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAdmin;

    @Column(name = "poste", nullable = false, length=255)
    String poste;

    // <dependency>
	// 		<groupId>org.springframework.boot</groupId>
	// 		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	// 	</dependency>
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    //get et set poste
    public String getposte(){
        return poste;
    }
    public void setposte(String post){
        this.poste=post;
    }

}
