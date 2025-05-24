package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {
}