package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.Pojo.TiquetePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.TiqueteRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeService;
import com.exemple.helpdesk.service.TiqueteService;
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
public class TiqueteController {
    @Autowired
    private TiqueteRepository tiqueteRepository;

    @Autowired
    private TiqueteService tiqueteService;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value ="/addTiquete",method= RequestMethod.POST)
    public Tiquete addDemande(@RequestBody TiquetePojo model, Authentication authentication) {
        /* authentication.getAuthorities() ;*/
        return tiqueteService.addDemande(model,authentication);

    }

    @RequestMapping( value="/Tiquetes",method= RequestMethod.GET)
    public Collection<Tiquete> getdemande(){

        return tiqueteRepository.findAll();
    }

    @RequestMapping(value = "/Tiquete/{id_tiquete}",method =RequestMethod.GET )
    public Optional<Tiquete> getProductsByNa(@PathVariable Long id_tiquete) {


        return  tiqueteRepository.findById(id_tiquete);

    }
    @RequestMapping( value="/TiqueteBy/{id}",method= RequestMethod.GET)
    public List<Tiquete> find_id_employer(@PathVariable Long id){

        return tiqueteRepository.find_id_employer(id);
    }

    @RequestMapping(value="/changeTiquete/{id_tiquete}",method=RequestMethod.PATCH)
    public Tiquete updadeDemande(@PathVariable Long id_tiquete, @RequestBody Tiquete c){
        Optional<Tiquete> d =tiqueteRepository.findById(id_tiquete);
        d.get().setStatus("En cours");
        Tiquete de=tiqueteRepository.save(d.get());

        return de;
    }


    @RequestMapping(value="/changeStatusTiquete/{id_tiquete}",method=RequestMethod.PATCH)
    public Tiquete changeStatus(@PathVariable Long id_tiquete, @RequestBody Tiquete c){
        Optional<Tiquete> d =tiqueteRepository.findById(id_tiquete);
        d.get().setStatus("Closed");
        Tiquete de=tiqueteRepository.save(d.get());

        return de;
    }
    @RequestMapping(value="/updateTiquete/{id_tiquete}",method=RequestMethod.PATCH)
    public Tiquete updateDemande(@PathVariable Long id_tiquete, @RequestBody Tiquete c,Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).get();
        c.setUser(user);
        c.setStatus("Waiting");
        c.setId_tiquete(id_tiquete);

        return tiqueteRepository.save(c);
    }

    @RequestMapping( value="/demandeCount",method= RequestMethod.GET)
    public long getCount(){

        return tiqueteRepository.findAll().stream().count();
    }
    @RequestMapping( value="/demandeCountWaiting",method= RequestMethod.GET)
    public long getCounts(){

        return tiqueteRepository.cherchers("Waiting").stream().count();
    }
    @RequestMapping( value="/countClosed",method= RequestMethod.GET)
    public long getCountClosed(){

        return tiqueteRepository.cherchers("Closed").stream().count();
    }
    @RequestMapping( value="/countCours",method= RequestMethod.GET)
    public long getCountEnCours(){

        return tiqueteRepository.cherchers("En cours").stream().count();
    }
    @RequestMapping( value="/cherchertiquete",method= RequestMethod.GET)
    public Collection<Tiquete> chercherDemande(@RequestParam(name = "mc",defaultValue = "") String mc){
        if(mc!=null){
            return tiqueteRepository.chercher(mc);
        }
        return tiqueteRepository.findAll();
    }
    @RequestMapping( value="/cherchertiquetes",method= RequestMethod.GET)
    public Collection<Tiquete> chercherDemandes(@RequestParam(name = "mc",defaultValue = "") String mc){
        if(mc!=null){
            return tiqueteRepository.cherchers(mc);
        }
        return tiqueteRepository.findAll();
    }
}
