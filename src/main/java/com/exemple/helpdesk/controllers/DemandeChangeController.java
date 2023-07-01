package com.exemple.helpdesk.controllers;


import com.exemple.helpdesk.Pojo.DemandeChangePojo;
import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.DemandeChange;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeChangeRepository;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeChangeService;
import com.exemple.helpdesk.service.DemandeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeChangeController {
    @Autowired
    private DemandeChangeRepository demandeChangeRepository;

    @Autowired
    private DemandeChangeService demandeChangeService;
    @Autowired
    private UserRepository userRepository;




    @RequestMapping(value ="/addDemandeChange",method= RequestMethod.POST)
    public DemandeChange addDemande(@RequestBody DemandeChangePojo model, Authentication authentication) {

        return demandeChangeService.addDemande(model,authentication);



    }





    @Secured(value={"ROLE_USER"})
    @RequestMapping( value="/demandeChange",method= RequestMethod.GET)
    public Collection<DemandeChange> getdemande(){

        return demandeChangeRepository.findAll();
    }

   /* @RequestMapping( value="/demanders/{id_demande}",method= RequestMethod.GET)
    public Long demandes(Long id_demande){

        return demanderepositor/.findAlla(id_demande);
    }
    @RequestMapping( value="/demander",method= RequestMethod.GET)
    public List<User> getContactss(Long id_demande){

        return demanderepositor.find_ide(id_demande);

    }*/


    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/


    @RequestMapping( value="/demandesChange/{id}",method= RequestMethod.GET)
    public List<DemandeChange> find_id_employer(@PathVariable Long id){

        return demandeChangeRepository.find_id_employers(id);
    }






    @RequestMapping(value = "/demaneChange/{id_tiquete}",method =RequestMethod.GET )
    public List<DemandeChange> getProductsByNa(@PathVariable String id_tiquete) {


        return  demandeChangeRepository.find_id_tiquete(id_tiquete);

    }

    @RequestMapping(value="/changeDemandeChange/{id_demandeChange}",method=RequestMethod.PATCH)
    public DemandeChange updadeDemande(@PathVariable Long id_demandeChange, @RequestBody DemandeChange c){
        Optional<DemandeChange> d =demandeChangeRepository.findById(id_demandeChange);
        d.get().setStatus("En cours");
        DemandeChange de=demandeChangeRepository.save(d.get());

        return de;
    }
    @RequestMapping(value="/changestatusChange/{id_demandeChange}",method=RequestMethod.PATCH)
    public DemandeChange changeStatus(@PathVariable Long id_demandeChange, @RequestBody DemandeChange c){
        Optional<DemandeChange> d =demandeChangeRepository.findById(id_demandeChange);
        d.get().setStatus("Closed");
        DemandeChange de=demandeChangeRepository.save(d.get());

        return de;
    }

    @RequestMapping(value="/updateDemandeChange/{id_demandeChange}",method=RequestMethod.PATCH)
    public DemandeChange updateDemande(@PathVariable Long id_demandeChange, @RequestBody DemandeChange c,Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        Optional<DemandeChange> d =demandeChangeRepository.findById(id_demandeChange);
        c.setUser(user);
        c.setStatus("Waiting");
        c.setType_Demande("IT Asset change");
        c.setMaterielChangeAncient(d.get().getMaterielChangeAncient());
        c.setMaterielChangeNew(d.get().getMaterielChangeNew());
        c.setId_demandeChange(id_demandeChange);

        return demandeChangeRepository.save(c);
    }


    @RequestMapping(value="/DeletedemandeChange/{id_demandeChange}",method=RequestMethod.DELETE)
    public boolean deleteDemande(@PathVariable Long id_demandeChange){
        this.demandeChangeService.deleteBy(id_demandeChange);
        return true;
    }

    @RequestMapping( value="/demandeCountChange/{id}",method= RequestMethod.GET)
    public long getCountss(@PathVariable Long id){

        return demandeChangeRepository.find_id_employers(id).stream().count();
    }

}
