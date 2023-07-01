package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.DemandeRetourVoucher;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.models.Demande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande,Long>{
      /* @Query("select dem from demande dem  where dem.id = :x")
    public List<Demande> find_id_employer(@Param("x") Long id);
    @Query("select dem from User dem  where dem.id = :x")
    public List<User> find_ide(@Param("x") Long id);
    @Query("select id  from demande dem where dem.id_demande = :x ")
    public Long findAlla(@Param("x") Long id_demande);*/


    /*@Query("select new com.exemple.helpdesk.models.Listedemande (u.prenom,u.username) from demande dem join User u")
    public List<Listedemande> getinformation();*/

    @Query("select dem from Demande dem  where user.id = :x")
    List<Demande> find_id_employer(@Param("x") Long id);
    @Query("select dem from Demande dem  where dem.tiquete_id = :x")
    List<Demande> find_id_tiquete(@Param("x") String tiquete_id);
    @Query("select dem from Demande dem  where user.username like :x")
    public List<Demande> chercher(@Param("x")String mc);
    @Query("select dem from Demande dem  where status like :x")
    public List<Demande> cherchers(@Param("x")String st);



}
