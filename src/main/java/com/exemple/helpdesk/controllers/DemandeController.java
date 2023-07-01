package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.UserRepository;
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
public class DemandeController {
    @Autowired
    private DemandeRepository demanderepositor;

    @Autowired
    private DemandeService demandeService;
    @Autowired
    private UserRepository userRepository;




    @RequestMapping(value ="/addDemande",method=RequestMethod.POST)
    public Demande addDemande(@RequestBody DemandePojo model, Authentication authentication) {
        /* authentication.getAuthorities() ;*/
        return demandeService.addDemande(model,authentication);



    }





    @Secured(value={"ROLE_USER"})
    @RequestMapping( value="/demande",method= RequestMethod.GET)
    public Collection<Demande> getdemande(){

        return demanderepositor.findAll();
    }
   /* @RequestMapping( value="/demandeCount",method= RequestMethod.GET)
    public long getCount(){

        return demanderepositor.findAll().stream().count();
    }
    @RequestMapping( value="/demandeCountWaiting",method= RequestMethod.GET)
    public long getCounts(){

        return demanderepositor.cherchers("Waiting").stream().count();
    }
    @RequestMapping( value="/countClosed",method= RequestMethod.GET)
    public long getCountClosed(){

        return demanderepositor.cherchers("Closed").stream().count();
    }
    @RequestMapping( value="/countCours",method= RequestMethod.GET)
    public long getCountEnCours(){

        return demanderepositor.cherchers("En cours").stream().count();
    }*/
   /* @RequestMapping( value="/demanders/{id_demande}",method= RequestMethod.GET)
    public Long demandes(Long id_demande){

        return demanderepositor/.findAlla(id_demande);
    }
    @RequestMapping( value="/demander",method= RequestMethod.GET)
    public List<User> getContactss(Long id_demande){

        return demanderepositor.find_ide(id_demande);

    }*/


    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/


    @RequestMapping( value="/demandes/{id}",method= RequestMethod.GET)
    public List<Demande> find_id_employer(@PathVariable Long id){

        return demanderepositor.find_id_employer(id);
    }


    @RequestMapping( value="/chercher",method= RequestMethod.GET)
    public Collection<Demande> chercherDemande(@RequestParam(name = "mc",defaultValue = "") String mc){
if(mc!=null){
    return demanderepositor.chercher(mc);
}
        return demanderepositor.findAll();
    }
    @RequestMapping( value="/cherchers",method= RequestMethod.GET)
    public Collection<Demande> chercherDemandeByStatus(@RequestParam(name = "st",defaultValue = "") String st){
        if(st!=null){
            return demanderepositor.cherchers(st);
        }
        return demanderepositor.findAll();
    }


    @RequestMapping(value = "/demane/{id_tiquete}",method =RequestMethod.GET )
    public List<Demande> getProductsByNa(@PathVariable String id_tiquete) {


        return  demanderepositor.find_id_tiquete(id_tiquete);

    }

    @RequestMapping(value="/changeDemande/{id_demande}",method=RequestMethod.PATCH)
    public Demande updadeDemande(@PathVariable Long id_demande, @RequestBody Demande c){
        Optional<Demande> d =demanderepositor.findById(id_demande);
        d.get().setStatus("En cours");
        Demande de=demanderepositor.save(d.get());

        return de;
    }
    @RequestMapping(value="/changestatus/{id_demande}",method=RequestMethod.PATCH)
    public Demande changeStatus(@PathVariable Long id_demande, @RequestBody Demande c){
        Optional<Demande> d =demanderepositor.findById(id_demande);
        d.get().setStatus("Closed");
        Demande de=demanderepositor.save(d.get());

        return de;
    }

    @RequestMapping(value="/updateDemande/{id_demande}",method=RequestMethod.PATCH)
    public Demande updateDemande(@PathVariable Long id_demande, @RequestBody Demande c,Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        Optional<Demande> d =demanderepositor.findById(id_demande);
        c.setUser(user);
        c.setStatus("Waiting");
        c.setId_demande(id_demande);
        c.setMateriel(d.get().getMateriel());

        return demanderepositor.save(c);
    }



    @RequestMapping(value="/Deletedemande/{id_demande}",method=RequestMethod.DELETE)
    public boolean deleteDemande(@PathVariable Long id_demande){
        this.demandeService.deleteBy(id_demande);
        return true;
    }
    @RequestMapping( value="/demandeCountRequest/{id}",method= RequestMethod.GET)
    public long getCountss(@PathVariable Long id){

        return demanderepositor.find_id_employer(id).stream().count();
    }
















}
