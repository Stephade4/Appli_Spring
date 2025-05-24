package com.example.demo.repository;

import com.example.demo.dto.PlanningConducteurDTO;
import com.example.demo.model.AssignerTrajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface AssignertrajetRepository extends JpaRepository<AssignerTrajet, Integer> {

    @Query(value = "SELECT * FROM assigner_trajet", nativeQuery = true)
    List<AssignerTrajet> findAllAssignments();

    @Query(value = "SELECT * FROM assigner_trajet WHERE idasign = :id", nativeQuery = true)
    AssignerTrajet findAssignmentById(@Param("id") int id);

    @Query(value = "INSERT INTO assigner_trajet (date_depart, heure_depart, date_arrive, heure_arrive, con_id, trajet_id, AffecteVehicul_id)"+
                    "VALUES (:dtdepart, :hdebut, :dtarrive, :hfin, :id_conduct, :id_trajet, :affecte)", nativeQuery = true)
    void addassignerTrajet(@Param("dtdepart") LocalDate dateDepart, @Param("hdebut") Time debut,
                             @Param("dtarrive") LocalDate dateArrivee, @Param("hfin") Time fin,
                             @Param("id_conduct") int idconducteur, @Param("id_trajet") int idtrajet, @Param("affecte") int affecte);
                              

    @Query(value = "UPDATE assigner_trajet SET date_depart = :dateDepart, heure_depart=:hdebut, date_arrive = :dateArrive,"+
                    "heure_arrive=:hfin, con_id = :idConducteur, trajet_id = :idTrajet, AffecteVehicul_id=: affecte"+
                    "WHERE idasign = :id", nativeQuery = true)
    void updateAssignment(@Param("id") int id, @Param("dateDepart") LocalDate depart, @Param("hdebut") Time debut, 
                            @Param("dateArrive") LocalDate arrive, @Param("hfin") Time fin,
                            @Param("idConducteur") int idConducteur, @Param("idTrajet") int idTrajet, @Param("affecte") int affecte);
                          

    @Query(value = "DELETE FROM assigner_trajet WHERE idasign = :id", nativeQuery = true)
    void deleteAssignment(@Param("id") int id);

    @Query(value = "SELECT COUNT(*) FROM assigner_trajet", nativeQuery = true)
    int countAssignments();

    @Query(value = "SELECT PlanningConducteurDTO(a.date_depart,a.heure_depart,a.date_arrive,a.heure_arrive,t,c) "+
                    "FROM assigner_trajet a "+
                    "Inner Join trajet t On a.trajet_id=t.idtrajet "+
                    "Inner Join classtrajet c On t.id_class=c.idclass "+
                    "WHERE a.con_id = :idConducteur", nativeQuery = true)
    List<PlanningConducteurDTO> findAssignmentsByConducteur(@Param("idConducteur") int idConducteur);

    @Query(value = "SELECT PlanningConducteurDTO(a.date_depart,a.heure_depart,a.date_arrive,a.heure_arrive,t,c) "+
                    "FROM assigner_trajet a "+
                    "Inner Join trajet t On a.trajet_id=t.idtrajet "+
                    "Inner Join classtrajet c On t.id_class=c.idclass "+
                    "WHERE a.trajet_id = :idTrajet", nativeQuery = true)
    List<PlanningConducteurDTO> findAssignmentsByTrajet(@Param("idTrajet") int idTrajet);
}