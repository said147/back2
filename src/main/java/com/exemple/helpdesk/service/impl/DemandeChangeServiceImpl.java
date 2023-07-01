package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.Pojo.DemandeChangePojo;
import com.exemple.helpdesk.Pojo.DemandeRetourVoucherPojo;
import com.exemple.helpdesk.models.DemandeChange;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import com.exemple.helpdesk.models.MaterielRetour;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeChangeRepository;
import com.exemple.helpdesk.repository.DemandeRetourVoucherRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeChangeServiceImpl implements DemandeChangeService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeChangeRepository demandeChangeRepository;
    @Override
    public DemandeChange addDemande(DemandeChangePojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        DemandeChange demandeChange = new DemandeChange();

        demandeChange.setStatus("Waiting");
        demandeChange.setDate(model.getDate());
        demandeChange.setTiquete_id(model.getTiquete_id());
        demandeChange.setType_Demande("IT Asset change");
        demandeChange.setDataURLEmploye(model.getDataURLEmploye());
        demandeChange.setUser(user);
        List<MaterielRetour> materielRetour  ;

        /*demande.setMateriel(model.getMateriel());*/

       /* materiel.setEquipement(model.getEquipement());
        materiel.setModel(model.getModel());
        materiel.setSerial(model.getSerial());
        materiel.setComment(model.getComment());*/

        demandeChange.setMaterielChangeAncient(model.getMaterielChangeAncient());
        demandeChange.setMaterielChangeNew(model.getMaterielChangeNew());

        /*  demande.setMateriels((List<Materiel>) materiel);*/
        /* Materiel materiel= new Materiel();
        demande.setMateriel((Set<Materiel>) materiel);*/


        return  demandeChangeRepository.save(demandeChange);
    }
    @Override
    public void deleteBy(Long id_demandeChange) {
        demandeChangeRepository.deleteById(id_demandeChange);

    }
}
