package com.exemple.helpdesk.service;

import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.Tiquete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface DemandeService {
    Demande addDemande(DemandePojo model , Authentication authentication);
    void deleteBy(Long idDemande);

}
