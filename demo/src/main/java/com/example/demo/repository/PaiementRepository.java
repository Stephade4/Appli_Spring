package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Integer> {

    
}
