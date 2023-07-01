package com.exemple.helpdesk.service.impl;


import com.exemple.helpdesk.Pojo.DemandeRetourVoucherPojo;
import com.exemple.helpdesk.models.*;
import com.exemple.helpdesk.repository.DemandeRetourVoucherRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeRetourVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class demandeRetourVoucherServiceImpl implements DemandeRetourVoucherService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeRetourVoucherRepository demandeRetourVoucherRepository;
    @Override
    public DemandeRetourVoucher addDemande(DemandeRetourVoucherPojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        DemandeRetourVoucher demandeRetourVoucher = new DemandeRetourVoucher();

        demandeRetourVoucher.setStatus("Waiting");
        demandeRetourVoucher.setReason(model.getReason());
        demandeRetourVoucher.setType_Demande("IT Asset return voucher");
        demandeRetourVoucher.setDate_retour(model.getDate_retour());
        demandeRetourVoucher.setName_verified(model.getName_verified());
        demandeRetourVoucher.setTiquete_id(model.getTiquete_id());
        demandeRetourVoucher.setDataURLEmploye(model.getDataURLEmploye());
        demandeRetourVoucher.setDataURLChecker(model.getDataURLChecker());
        demandeRetourVoucher.setUser(user);
        List<MaterielRetour> materielRetour  ;

        /*demande.setMateriel(model.getMateriel());*/

       /* materiel.setEquipement(model.getEquipement());
        materiel.setModel(model.getModel());
        materiel.setSerial(model.getSerial());
        materiel.setComment(model.getComment());*/

        demandeRetourVoucher.setMaterielRetour(model.getMaterielRetour());
        System.out.println(model.getMaterielRetour());
        /*  demande.setMateriels((List<Materiel>) materiel);*/
        /* Materiel materiel= new Materiel();
        demande.setMateriel((Set<Materiel>) materiel);*/


        return  demandeRetourVoucherRepository.save(demandeRetourVoucher);
    }
    @Override
    public void deleteBy(Long id_demandeTelework) {
        demandeRetourVoucherRepository.deleteById(id_demandeTelework);

    }
}
