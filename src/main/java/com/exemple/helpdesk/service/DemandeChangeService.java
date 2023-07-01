package com.exemple.helpdesk.service;

import com.exemple.helpdesk.Pojo.DemandeChangePojo;
import com.exemple.helpdesk.Pojo.DemandeRetourVoucherPojo;
import com.exemple.helpdesk.models.DemandeChange;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import org.springframework.security.core.Authentication;

public interface DemandeChangeService {
    DemandeChange addDemande(DemandeChangePojo model , Authentication authentication);
    void deleteBy(Long id_demandeChange);
}
