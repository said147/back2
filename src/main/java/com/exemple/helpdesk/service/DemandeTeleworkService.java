package com.exemple.helpdesk.service;


import com.exemple.helpdesk.Pojo.DemandeTeleworkPojo;
import com.exemple.helpdesk.models.DemandeTelework;
import org.springframework.security.core.Authentication;

public interface DemandeTeleworkService {
    DemandeTelework addDemande(DemandeTeleworkPojo model , Authentication authentication);

    void deleteBy(Long id_demandeTelework);
}
