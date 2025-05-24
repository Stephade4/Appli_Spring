package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
}