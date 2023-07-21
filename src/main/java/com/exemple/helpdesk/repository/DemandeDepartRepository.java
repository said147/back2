package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.DemandeDepart;
import com.exemple.helpdesk.models.DemandeTelework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeDepartRepository  extends JpaRepository<DemandeDepart,Long> {
    @Query("select dem from DemandeDepart dem  where user.id = :x")
    List<DemandeDepart> find_id_employer(@Param("x") Long id);

    @Query("select dem from DemandeDepart dem  where user.username like :x")
    public List<DemandeDepart> chercherss(@Param("x")String mc);
}
