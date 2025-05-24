package com.example.demo.repository;

import com.example.demo.model.TypeUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeuserRepository extends JpaRepository<TypeUser, Integer> {

    @Query(value = "INSERT INTO TypeUser (libelleType, date_creation) VALUES (:libelleType, NOW())", nativeQuery = true)
    void ajouterTypeUser(@Param("libelleType") String libelleType);

    @Query(value = "UPDATE TypeUser SET libelleType = :libelleType, date_creation = NOW() WHERE idTypeUser = :id", nativeQuery = true)
    void modifierTypeUser(@Param("id") int id, @Param("libelleType") String libelleType);
    
    @Query(value = "DELETE FROM TypeUser WHERE idTypeUser = :id", nativeQuery = true)
    void supprimerTypeUser(@Param("id") int id);

    @Query(value = "SELECT * FROM TypeUser", nativeQuery = true)
    List<TypeUser> listerTypeUsers();

    @Query(value = "SELECT * FROM TypeUser WHERE idTypeUser = :id", nativeQuery = true)
    TypeUser rechercherParId(@Param("id") int id);

    @Query(value = "SELECT COUNT(*) FROM TypeUser", nativeQuery = true)
    int compterTypeUsers();

    @Query(value = "SELECT idTypeUser FROM TypeUser WHERE libelle_type = ?1", nativeQuery = true)
    int findTypeUserIdByName(String typeNom);
}