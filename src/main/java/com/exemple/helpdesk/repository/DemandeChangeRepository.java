package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.DemandeChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeChangeRepository extends JpaRepository<DemandeChange,Long> {
    @Query("select dem from DemandeChange dem  where user.id = :x")
    List<DemandeChange> find_id_employers(@Param("x") Long id);
    @Query("select dem from DemandeChange dem  where dem.tiquete_id = :x")
    List<DemandeChange> find_id_tiquete(@Param("x") String tiquete_id);

    @Query("select dem from DemandeChange dem  where user.username like :x")
    public List<DemandeChange> chercher(@Param("x")String mc);
    @Query("select dem from DemandeChange dem  where status like :x")
    public List<DemandeChange> cherchers(@Param("x")String st);
}
