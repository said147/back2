package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.Pojo.TiquetePojo;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.TiqueteRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.TiqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TiqueteServiceImpl implements TiqueteService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TiqueteRepository tiqueteRepository;

    @Override
    public Tiquete addDemande(TiquetePojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        Tiquete tiquete = new Tiquete();
        tiquete.setDate(new Date());
        tiquete.setStatus("Waiting");
        tiquete.setType_Request(model.getType_Request());
        tiquete.setMessage(model.getMessage());
        tiquete.setUser(user);


        /*demande.setMateriel(model.getMateriel());*/

       /* materiel.setEquipement(model.getEquipement());
        materiel.setModel(model.getModel());
        materiel.setSerial(model.getSerial());
        materiel.setComment(model.getComment());*/



        /*  demande.setMateriels((List<Materiel>) materiel);*/
        /* Materiel materiel= new Materiel();
        demande.setMateriel((Set<Materiel>) materiel);*/

        return tiqueteRepository.save(tiquete);
    }
}
