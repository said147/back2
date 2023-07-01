package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.Pojo.DemandeTeleworkPojo;
import com.exemple.helpdesk.models.*;
import com.exemple.helpdesk.repository.DemandeTeleworkRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeTeleworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeTeleworkServiceImpl implements DemandeTeleworkService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DemandeTeleworkRepository demandeTeleworkRepository;

    public DemandeTelework addDemande(DemandeTeleworkPojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        DemandeTelework demandeTelework = new DemandeTelework();

        demandeTelework.setStatus("Waiting");
        demandeTelework.setDate(model.getDate());
        demandeTelework.setType_Demande("IT Asset Telework");
        demandeTelework.setAdresse(model.getAdresse());
        demandeTelework.setDataURLEmploye(model.getDataURLEmploye());
        demandeTelework.setDataURLCheker(model.getDataURLCheker());
        demandeTelework.setUser(user);
        List<MaterielTelework> materielTelework  ;

        /*demande.setMateriel(model.getMateriel());*/

       /* materiel.setEquipement(model.getEquipement());
        materiel.setModel(model.getModel());
        materiel.setSerial(model.getSerial());
        materiel.setComment(model.getComment());*/

        demandeTelework.setMaterielTelework(model.getMaterielTelework());
        /*System.out.println(model.getMaterielRetour());*/
        /*  demande.setMateriels((List<Materiel>) materiel);*/
        /* Materiel materiel= new Materiel();
        demande.setMateriel((Set<Materiel>) materiel);*/


        return  demandeTeleworkRepository.save(demandeTelework);
    }

    @Override
    public void deleteBy(Long idDemandeRetour) {
        demandeTeleworkRepository.deleteById(idDemandeRetour);
    }
}
