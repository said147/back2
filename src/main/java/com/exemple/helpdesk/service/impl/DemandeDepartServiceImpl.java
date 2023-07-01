package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.Pojo.DemandeDepartPojo;
import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.DemandeDepart;
import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeDepartRepository;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.TiqueteRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeDepartServiceImpl implements DemandeDepartService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private DemandeDepartRepository demandeDepartRepository;
    @Override
    public DemandeDepart addDemande(DemandeDepartPojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        DemandeDepart demande = new DemandeDepart();
        demande.setMatricule(model.getMatricule());
        demande.setResp_hier(model.getResp_hier());
        demande.setStatus("Waiting");
        demande.setEmail_perso(model.getEmail_perso());
        demande.setTel_perso(model.getTel_perso());
        demande.setDate_Depart(model.getDate_Depart());
        demande.setDate_Entree(model.getDate_Entree());
        demande.setActivite(model.getActivite());
        demande.setType_Demande("Depart");
        demande.setDataURL(model.getDataURL());
        demande.setTheme_RHi(false);
        demande.setComment_RHi(null);

        demande.setTheme_IT(false);
        demande.setComment_IT(null);

        demande.setTheme_RH(false);
        demande.setComment_RH(null);

        demande.setTheme_FINANCES(false);
        demande.setComment_FINANCES(null);

        demande.setTheme_AMG(false);
        demande.setComment_AMG(null);


        demande.setUser(user);



        return  demandeDepartRepository.save(demande);
    }

    @Override
    public void deleteByy(Long idDemandeDepart) {
        demandeDepartRepository.deleteById(idDemandeDepart);
    }
}
