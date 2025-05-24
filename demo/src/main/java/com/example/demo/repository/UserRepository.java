package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Récupérer tous les utilisateurs
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsers();

    // Récupérer un utilisateur par son ID
    @Query(value = "SELECT * FROM users WHERE idUser = ?1", nativeQuery = true)
    User getUserById(int id);

    // Ajouter un utilisateur
    @Modifying
    @Query(value = "INSERT INTO users (nom, email, password, tel, typeuser_id, creationDate) VALUES (?1, ?2, ?3, ?4 ,?5, NOW())", nativeQuery = true)
    void addUser(String nom, String email, String pass, String tel, int typeUserId);

    // Modifier un utilisateur
    @Modifying
    @Query(value = "UPDATE users SET nom = ?2, email = ?3, password = ?4, telephone = ?5, typeuser_id = ?6 WHERE idUser = ?1", nativeQuery = true)
    void updateUser(int id, String nom, String email, String pass, String tel, int typeUserId);

    // Supprimer un utilisateur
    @Modifying
    @Query(value = "DELETE FROM users WHERE idUser = ?1", nativeQuery = true)
    void deleteUser(int id);

    // Compter le nombre total d’utilisateurs
    @Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
    int countUsers();

    @Query(value = "SELECT idUser FROM users ORDER BY idUser DESC LIMIT 1", nativeQuery = true)
    int getDernierUserCree();

    @Query(value = "SELECT idUser FROM users WHERE nom = ?1", nativeQuery = true)
    int findIdBynom(String nom);
}