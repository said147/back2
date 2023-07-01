package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TiqueteRepository extends JpaRepository<Tiquete,Long> {
    @Query("select dem from Tiquete dem  where user.id = :x")
    List<Tiquete> find_id_employer(@Param("x") Long id);
    @Query("select dem from Tiquete dem  where user.username like :x")
    public List<Tiquete> chercher(@Param("x")String mc);
    @Query("select dem from Tiquete dem  where status like :x")
    public List<Tiquete> cherchers(@Param("x")String st);

}
