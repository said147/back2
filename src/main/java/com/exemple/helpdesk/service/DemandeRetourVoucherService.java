package com.exemple.helpdesk.service;

import com.exemple.helpdesk.Pojo.DemandeRetourVoucherPojo;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import org.springframework.security.core.Authentication;

public interface DemandeRetourVoucherService {
    DemandeRetourVoucher addDemande(DemandeRetourVoucherPojo model , Authentication authentication);
    void deleteBy(Long idDemande);
}
