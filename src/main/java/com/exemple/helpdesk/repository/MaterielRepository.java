package com.exemple.helpdesk.repository;


import com.exemple.helpdesk.models.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {
    @Query("select mat from Materiel mat  where demande.id_demande = :x")
    List<Materiel> find_id_demande(@Param("x") Long id_demande);
    @Query("select mat from Materiel mat  where demande.user.username = :x")
    List<Materiel> findByUser(@Param("x") String username);
}
