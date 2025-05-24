package com.example.demo.repository;

import com.example.demo.dto.TrajetClassDTO;
import com.example.demo.dto.compteTrajetDTO;
import com.example.demo.model.Trajet;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO trajet (ville_depart, ville_arrive, distance, tarif, statut,id_class) " +
            "VALUES (:ville_depart, :ville_arrive, :distance, :tarif, :statut, :id_class)", nativeQuery = true)
    void addTrajet(@Param("ville_depart") String ville_depart, @Param("ville_arrive") String ville_arrive,
                       @Param("distance") Double distance,@Param("tarif") Double tarif, 
                       @Param("statut") String statut, @Param("id_class") int id_class);

    @Modifying
    @Transactional
    @Query(value = "UPDATE trajet SET ville_depart = :villeDepart, ville_arrive = :villeArrivee, " +
            "distance = :distance, tarif = :tarif, statut = :statut, id_class = :id_class " +
            "WHERE idtrajet = :id", nativeQuery = true)
    void updateTrajet(@Param("id") int id, @Param("villeDepart") String villeDepart,
                        @Param("villeArrivee") String villeArrivee, @Param("distance") Double distance,
                        @Param("tarif") Double tarif, @Param("statut") String statut, 
                        @Param("id_class") int id_classtrajet);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM trajet WHERE idtrajet = :id", nativeQuery = true)
    void deleteTrajet(@Param("id") int id);

    @Query(value = "SELECT new com.example.demo.dto.compteTrajetDTO(COUNT(*)) FROM trajet", nativeQuery = true)
    compteTrajetDTO countTrajets();

    @Query(value = "SELECT new com.example.demo.dto.TrajetClassDTO(t.ville_depart,t.arrive,t.distance,t.tarif,t.statut,c.libelle) FROM trajet t, classtrajet c", nativeQuery = true)
    List<TrajetClassDTO> listerTrajets();

    @Query(value = "SELECT new com.example.demo.dto.TrajetClassDTO(t.ville_depart,t.ville_arrive,t.distance,t.tarif,t.statut,c.libelle) FROM trajet t, classtrajet c WHERE t.idtrajet = :id", nativeQuery = true)
    TrajetClassDTO rechercherParId(@Param("id") int id);

    @Query(value = "SELECT new com.example.demo.dto.TrajetClassDTO(t.ville_depart,t.ville_arrive,t.distance,t.tarif,t.statut,c.libelle) FROM trajet T, classtrajet c WHERE t.ville_depart = :depart", nativeQuery = true)
    List<TrajetClassDTO> rechercherParVille(@Param("depart") String vildepart);

    @Query(value = "SELECT idtrajet FROM trajet WHERE ville_depart = :depart & ville_arrive = arrive", nativeQuery = true)
    int rechercherIdParVille(@Param("depart") String vildepart, @Param("arrive") String vilarrive);
}