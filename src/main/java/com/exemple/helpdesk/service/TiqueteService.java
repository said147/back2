package com.exemple.helpdesk.service;

import com.exemple.helpdesk.Pojo.TiquetePojo;
import com.exemple.helpdesk.models.Tiquete;
import org.springframework.security.core.Authentication;

public interface TiqueteService {

    Tiquete addDemande(TiquetePojo model , Authentication authentication);
}
