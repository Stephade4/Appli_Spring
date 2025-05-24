package com.example.demo.repository;

import com.example.demo.model.ClassTrajet;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasstrajetRepository extends JpaRepository<ClassTrajet, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO classtrajet (libelle) VALUES (:libelle)", nativeQuery = true)
    void addClassTrajet(@Param("libelle") String libelle);

    @Modifying
    @Transactional
    @Query(value = "UPDATE classtrajet SET libelle_classe = :libelle WHERE idclass = :id", nativeQuery = true)
    void updateClassTrajet(@Param("id") int id, @Param("libelle") String libelle);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM classtrajet WHERE idclass = :id", nativeQuery = true)
    void deleteClassTrajet(@Param("id") int id);

    @Query(value = "SELECT * FROM classtrajet", nativeQuery = true)
    List<ClassTrajet> getAllClassTrajets();

    @Query(value = "SELECT libelle FROM classtrajet WHERE idclass = :id", nativeQuery = true)
    String getClassTrajetByid(@Param("id") int idclass);

    @Query(value = "SELECT idclass FROM classtrajet WHERE libelle = :lib", nativeQuery = true)
    int getClassTrajetByname(@Param("lib") String libelle);

    @Query(value = "SELECT COUNT(*) FROM classtrajet", nativeQuery = true)
    int countClassTrajets();
}