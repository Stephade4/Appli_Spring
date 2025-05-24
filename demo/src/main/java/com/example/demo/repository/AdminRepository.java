package com.example.demo.repository;

import com.example.demo.dto.UserAdminDTO;
import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    @Query(value = "INSERT INTO admin (poste, user_id) VALUES ( :post, :idUser)", nativeQuery = true)
    void addAdmin(@Param("post") String post, @Param("idUser") int idUser);

    @Query(value = "UPDATE admin SET poste =:post, user_id = :newIdUser WHERE id_admin = :idAdmin", nativeQuery = true)
    void updateAdmin(@Param("post") String post, @Param("newIdUser") int newIdUser);

    @Query(value = "DELETE FROM admin WHERE idAdmin = :idAdmin", nativeQuery = true)
    void deleteAdmin( @Param("idAdmin") int idAdmin);

    @Query(value = "SELECT UserAdminDTO(u ,a) FROM admin a, users u WHERE a.user_id=u.idUser", nativeQuery = true)
    List<UserAdminDTO> getAllAdmins();

    @Query(value = "SELECT UserAdminDTO(a ,u ) "+
                    "FROM user u INNER JOIN admin a ON a.user_id = u.idUser "+
                    "WHERE u.nom = :nom", nativeQuery = true)
    UserAdminDTO getAdminByUserNom(@Param("nom") String nom);

    @Query(value = "SELECT COUNT(*) FROM admin", nativeQuery = true)
    int countAdmins();
}