package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.DemandeRetourVoucher;
import com.exemple.helpdesk.models.DemandeTelework;
import com.exemple.helpdesk.models.Tiquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeTeleworkRepository extends JpaRepository<DemandeTelework,Long> {
    @Query("select dem from DemandeTelework dem  where user.id = :x")
    List<DemandeTelework> find_id_employer(@Param("x") Long id);

    @Query("select dem from DemandeTelework dem  where user.username like :x")
    public List<DemandeTelework> chercher(@Param("x")String mc);
    @Query("select dem from DemandeTelework dem  where status like :x")
    public List<DemandeTelework> cherchers(@Param("x")String st);
    @Query("select dem from DemandeTelework dem  where user.username like :x")
    public List<DemandeTelework> chercherss(@Param("x")String mc);

}
