package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandeRetourVoucherPojo;
import com.exemple.helpdesk.models.DemandeRetourVoucher;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeRetourVoucherRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeRetourVoucherService;
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
public class demandeRetourVoucherController {
    @Autowired
    private DemandeRetourVoucherRepository demandeRetourVoucherRepository;

    @Autowired
    private DemandeRetourVoucherService demandeRetourVoucherService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value ="/addDemandeRetour",method= RequestMethod.POST)
    public DemandeRetourVoucher addDemande(@RequestBody DemandeRetourVoucherPojo model, Authentication authentication) {
        /* authentication.getAuthorities() ;*/
        return demandeRetourVoucherService.addDemande(model,authentication);



    }





    @Secured(value={"ROLE_USER"})
    @RequestMapping( value="/demandeRetour",method= RequestMethod.GET)
    public Collection<DemandeRetourVoucher> getdemande(){

        return demandeRetourVoucherRepository.findAll();
    }
    @RequestMapping( value="/demandeCountRetour",method= RequestMethod.GET)
    public long getCount(){

        return demandeRetourVoucherRepository.findAll().stream().count();
    }
    @RequestMapping( value="/demandeCountWaitingRetour",method= RequestMethod.GET)
    public long getCounts(){

        return demandeRetourVoucherRepository.cherchers("Waiting").stream().count();
    }
    @RequestMapping( value="/countClosedRetour",method= RequestMethod.GET)
    public long getCountClosed(){

        return demandeRetourVoucherRepository.cherchers("Closed").stream().count();
    }
    @RequestMapping( value="/countCoursRetour",method= RequestMethod.GET)
    public long getCountEnCours(){

        return demandeRetourVoucherRepository.cherchers("En cours").stream().count();
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

    @RequestMapping( value="/demandesRetour/{id}",method= RequestMethod.GET)
    public List<DemandeRetourVoucher> find_id_employer(@PathVariable Long id){

        return demandeRetourVoucherRepository.find_id_employer(id);
    }


    @RequestMapping( value="/chercherRetour",method= RequestMethod.GET)
    public Collection<DemandeRetourVoucher> chercherDemande(@RequestParam(name = "mc",defaultValue = "") String mc){
        if(mc!=null){
            return demandeRetourVoucherRepository.chercher(mc);
        }
        return demandeRetourVoucherRepository.findAll();
    }
    @RequestMapping( value="/cherchersRetour",method= RequestMethod.GET)
    public Collection<DemandeRetourVoucher> chercherDemandeByStatus(@RequestParam(name = "st",defaultValue = "") String st){
        if(st!=null){
            return demandeRetourVoucherRepository.cherchers(st);
        }
        return demandeRetourVoucherRepository.findAll();
    }

//
    @RequestMapping(value = "/demaneRetour/{id_tiquete}",method =RequestMethod.GET )
    public List<DemandeRetourVoucher> getProductsByNa(@PathVariable String id_tiquete) {


        return  demandeRetourVoucherRepository.find_id_tiquete(id_tiquete);

    }
////
    @RequestMapping(value="/changeDemandeRetour/{id_demandeRetour}",method=RequestMethod.PATCH)
    public DemandeRetourVoucher updadeDemande(@PathVariable Long id_demandeRetour, @RequestBody DemandeRetourVoucher c){
        Optional<DemandeRetourVoucher> d =demandeRetourVoucherRepository.findById(id_demandeRetour);
        d.get().setStatus("En cours");

        d.get().setName_verified("said10 raggad10");

        DemandeRetourVoucher de=demandeRetourVoucherRepository.save(d.get());

        return de;
    }
    @RequestMapping(value="/changestatusRetour/{id_demandeRetour}",method=RequestMethod.PATCH)
    public DemandeRetourVoucher changeStatus(@PathVariable Long id_demandeRetour, @RequestBody DemandeRetourVoucher c){
        Optional<DemandeRetourVoucher> d =demandeRetourVoucherRepository.findById(id_demandeRetour);
        d.get().setStatus("Closed");

        DemandeRetourVoucher de=demandeRetourVoucherRepository.save(d.get());

        return de;
    }

    @RequestMapping(value="/updateDemandeRetour/{id_demandeRetour}",method=RequestMethod.PATCH)
    public DemandeRetourVoucher updateDemande(@PathVariable Long id_demandeRetour, @RequestBody DemandeRetourVoucher c,Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        Optional<DemandeRetourVoucher> d =demandeRetourVoucherRepository.findById(id_demandeRetour);
        c.setUser(user);
        c.setStatus("Waiting");
        c.setType_Demande("IT Asset return voucher");
        c.setId_demandeRetour(id_demandeRetour);
c.setMaterielRetour(d.get().getMaterielRetour());
        return demandeRetourVoucherRepository.save(c);
    }


    @RequestMapping(value="/DeletedemandeRetour/{id_demandeRetour}",method=RequestMethod.DELETE)
    public boolean deleteDemande(@PathVariable Long id_demandeRetour){
        this.demandeRetourVoucherService.deleteBy(id_demandeRetour);
        return true;
    }
    @RequestMapping( value="/demandeCountReturn/{id}",method= RequestMethod.GET)
    public long getCountss(@PathVariable Long id){

        return demandeRetourVoucherRepository.find_id_employer(id).stream().count();
    }















}
