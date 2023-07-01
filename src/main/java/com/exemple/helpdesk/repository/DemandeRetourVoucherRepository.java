package com.exemple.helpdesk.repository;


import com.exemple.helpdesk.models.DemandeChange;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRetourVoucherRepository extends JpaRepository<DemandeRetourVoucher,Long> {
    @Query("select dem from DemandeRetourVoucher dem  where user.id = :x")
    List<DemandeRetourVoucher> find_id_employer(@Param("x") Long id);
    @Query("select dem from DemandeRetourVoucher dem  where dem.tiquete_id = :x")
    List<DemandeRetourVoucher> find_id_tiquete(@Param("x") String tiquete_id);
    @Query("select dem from DemandeRetourVoucher dem  where user.username like :x")
    public List<DemandeRetourVoucher> chercher(@Param("x")String mc);
    @Query("select dem from DemandeRetourVoucher dem  where status like :x")
    public List<DemandeRetourVoucher> cherchers(@Param("x")String st);
}
