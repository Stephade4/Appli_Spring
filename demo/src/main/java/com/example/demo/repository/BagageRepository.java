package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bagage;

public interface BagageRepository extends JpaRepository<Bagage, Integer> {
}
