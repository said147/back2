package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandeChangePojo;
import com.exemple.helpdesk.Pojo.DemandeDepartPojo;
import com.exemple.helpdesk.models.*;
import com.exemple.helpdesk.repository.DemandeDepartRepository;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeDepartService;
import com.exemple.helpdesk.service.DemandeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DemandeDepartController {
    @Autowired
    private DemandeDepartRepository demandeDepartRepository;

    @Autowired
    private DemandeDepartService demandeDepartService;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value ="/addDemandeDepart",method= RequestMethod.POST)
    public DemandeDepart addDemande(@RequestBody DemandeDepartPojo model, Authentication authentication) {

        return demandeDepartService.addDemande(model,authentication);



    }
    @RequestMapping( value="/demandesDepart/{id}",method= RequestMethod.GET)
    public List<DemandeDepart> find_id_employer(@PathVariable Long id){

        return demandeDepartRepository.find_id_employer(id);
    }
    @RequestMapping( value="/demandeDepart",method= RequestMethod.GET)
    public Collection<DemandeDepart> getdemande(){

        return demandeDepartRepository.findAll();
    }

    @RequestMapping(value = "/demaneDepart/{id_demandeDepart}",method =RequestMethod.GET )
    public Optional<DemandeDepart> getProductsByNa(@PathVariable Long id_demandeDepart) {


        return  demandeDepartRepository.findById(id_demandeDepart);

    }
    @RequestMapping(value="/updateDemandeDepart/{id_demandeDepart}",method=RequestMethod.PATCH)
    public DemandeDepart updateDemande(@PathVariable Long id_demandeDepart, @RequestBody DemandeDepart c, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        c.setUser(user);
        c.setStatus("Waiting");

        c.setId_demandeDepart(id_demandeDepart);

        return demandeDepartRepository.save(c);
    }
    @RequestMapping(value="/DeletedemandDepart/{id_demandeDepart}",method=RequestMethod.DELETE)
    public List<DemandeDepart> deleteDemandeaa(@PathVariable Long id_demandeDepart){
        this.demandeDepartRepository.deleteById(id_demandeDepart);
        return demandeDepartRepository.findAll();
    }
}
