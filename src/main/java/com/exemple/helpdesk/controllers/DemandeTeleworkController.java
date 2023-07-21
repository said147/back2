package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandeTeleworkPojo;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import com.exemple.helpdesk.models.DemandeTelework;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeTeleworkRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeTeleworkService;
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
public class DemandeTeleworkController {
    @Autowired
    private DemandeTeleworkRepository demandeTeleworkRepository;

    @Autowired
    private DemandeTeleworkService demandeTeleworkService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value ="/addDemandeTelework",method= RequestMethod.POST)
    public DemandeTelework addDemande(@RequestBody DemandeTeleworkPojo model, Authentication authentication) {
        /* authentication.getAuthorities() ;*/
        return demandeTeleworkService.addDemande(model,authentication);



    }





    @Secured(value={"ROLE_USER"})
    @RequestMapping( value="/demandeTelework",method= RequestMethod.GET)
    public Collection<DemandeTelework> getdemande(){

        return demandeTeleworkRepository.findAll();
    }
    @RequestMapping( value="/demandeCountTelework",method= RequestMethod.GET)
    public long getCount(){

        return demandeTeleworkRepository.findAll().stream().count();
    }
    @RequestMapping( value="/demandeCountWaitingTelework",method= RequestMethod.GET)
    public long getCounts(){

        return demandeTeleworkRepository.cherchers("Waiting").stream().count();
    }
    @RequestMapping( value="/countClosedTelework",method= RequestMethod.GET)
    public long getCountClosed(){

        return demandeTeleworkRepository.cherchers("Closed").stream().count();
    }
    @RequestMapping( value="/countCoursTelework",method= RequestMethod.GET)
    public long getCountEnCours(){

        return demandeTeleworkRepository.cherchers("En cours").stream().count();
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
   /* @RequestMapping(value = "/demaneRetour/{id_demandeRetour}",method =RequestMethod.GET )
    public Optional<DemandeRetourVoucher> getProductsByNaz(@PathVariable Long id_demandeRetour) {


        return  demandeRetourVoucherRepository.findById(id_demandeRetour);

    }*/

    @RequestMapping( value="/demandesTelework/{id}",method= RequestMethod.GET)
    public List<DemandeTelework> find_id_employer(@PathVariable Long id){

        return demandeTeleworkRepository.find_id_employer(id);
    }


    @RequestMapping( value="/chercherTelework",method= RequestMethod.GET)
    public Collection<DemandeTelework> chercherDemande(@RequestParam(name = "mc",defaultValue = "") String mc){
        if(mc!=null){
            return demandeTeleworkRepository.chercher(mc);
        }
        return demandeTeleworkRepository.findAll();
    }
    @RequestMapping( value="/cherchersTelework",method= RequestMethod.GET)
    public Collection<DemandeTelework> chercherDemandeByStatus(@RequestParam(name = "st",defaultValue = "") String st){
        if(st!=null){
            return demandeTeleworkRepository.cherchers(st);
        }
        return demandeTeleworkRepository.findAll();
    }

    //
    @RequestMapping(value = "/demaneTelework/{id_demandeTelework}",method =RequestMethod.GET )
    public Optional<DemandeTelework> getProductsByNa(@PathVariable Long id_demandeTelework) {


        return  demandeTeleworkRepository.findById(id_demandeTelework);

    }

    @RequestMapping(value="/changeDemandeTelework/{id_demandeTelework}",method=RequestMethod.PATCH)
    public DemandeTelework updadeDemande(@PathVariable Long id_demandeTelework, @RequestBody DemandeTelework c){
        Optional<DemandeTelework> d =demandeTeleworkRepository.findById(id_demandeTelework);
        d.get().setStatus("En cours");
        DemandeTelework de=demandeTeleworkRepository.save(d.get());

        return de;
    }
    @RequestMapping(value="/changestatusTelework/{id_demandeTelework}",method=RequestMethod.PATCH)
    public DemandeTelework changeStatus(@PathVariable Long id_demandeTelework, @RequestBody DemandeTelework c){
        Optional<DemandeTelework> d =demandeTeleworkRepository.findById(id_demandeTelework);
        d.get().setStatus("Closed");
        DemandeTelework de=demandeTeleworkRepository.save(d.get());

        return de;
    }

    @RequestMapping(value="/updateDemandeTelework/{id_demandeTelework}",method=RequestMethod.PATCH)
    public DemandeTelework updateDemande(@PathVariable Long id_demandeTelework, @RequestBody DemandeTelework c,Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        c.setUser(user);
        c.setStatus("Waiting");
        c.setType_Demande( "IT Asset Telework");
        c.setId_demandeTelework(id_demandeTelework);

        return demandeTeleworkRepository.save(c);
    }



    /*@RequestMapping(value="/DeletedemandeTelework/{id_demandeTelework}",method=RequestMethod.DELETE)
    public List<DemandeTelework> deleteDemande(@PathVariable Long id_demandeTelework){


        this.demandeTeleworkService.deleteBy(id_demandeTelework);
        return demandeTeleworkRepository.findAll();
    }*/
    @RequestMapping( value="/demandeCountTelework/{id}",method= RequestMethod.GET)
    public long getCountss(@PathVariable Long id){

        return demandeTeleworkRepository.find_id_employer(id).stream().count();
    }
    @RequestMapping( value="/chercherteleworks",method= RequestMethod.GET)
    public Collection<DemandeTelework> chercherDemandess(@RequestParam(name = "mc",defaultValue = "") String mc){
        if(mc!=null){
            return demandeTeleworkRepository.chercherss(mc);
        }
        return demandeTeleworkRepository.findAll();
    }


}
