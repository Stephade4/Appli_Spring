package com.sad366.compagnie_transports.Tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom_prenom_clt;
    private String numCNI_clt;
    private String email_clt;
    private String telephone_clt;
    private String profession_clt;
    private String password_clt;

    @ManyToOne
    private User user;


}
