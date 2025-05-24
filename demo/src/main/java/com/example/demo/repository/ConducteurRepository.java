package com.example.demo.repository;

import com.example.demo.dto.UserConducteurDTO;
import com.example.demo.model.Conducteur;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Integer> {

    @Query(value = "SELECT UserConducteurDTO(u ,c.permis ,c.disponibilite,c.experience) FROM conducteur c, users u WHERE c.User= u.User", nativeQuery = true)
    List<UserConducteurDTO> getAllConducteurs();

    @Query(value = "SELECT UserConducteurDTO(u,c.permis,u.disponibilite,u.experience) FROM conducteur c, users u WHERE u.nom = ?1 & u.idUser=c.user_id", nativeQuery = true)
    List<UserConducteurDTO> getConducteurByname(String nom);

    @Modifying
    @Query(value = "INSERT INTO conducteur (user_id, permis, disponibilite, experience ) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void addConducteur(int id, String permis, Boolean dispo, int exp);

    @Modifying
    @Query(value = "UPDATE conducteur SET permis = ?2, disponibilite = ?3, experience = ?4 WHERE user_id = ?1", nativeQuery = true)
    void updateConducteur(int id, String permis, Boolean dispo, int exp);

    @Modifying
    @Query(value = "DELETE FROM conducteur WHERE user_id = ?1", nativeQuery = true)
    void deleteConducteur(int id);

    @Query(value = "SELECT COUNT(*) FROM conducteur", nativeQuery = true)
    int countConducteurs();

}