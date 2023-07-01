package com.exemple.helpdesk.service;

import com.exemple.helpdesk.Pojo.DemandeDepartPojo;
import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.DemandeDepart;
import org.springframework.security.core.Authentication;

public interface DemandeDepartService {
    DemandeDepart addDemande(DemandeDepartPojo model , Authentication authentication);

    void deleteByy(Long idDemandeDepart);
}
