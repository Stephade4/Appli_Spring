package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> 
{
    // boolean existsByNumCni(String numcni);
    // boolean existsByEmail(String email);
}
