package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.repository.MaterielRepository;
import com.exemple.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MaterielController {
    @Autowired
    private MaterielRepository materielrepositor;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/material",method= RequestMethod.GET)
    public List<Materiel> getMateriels(){

        return materielrepositor.findAll();
    }
    @RequestMapping(value ="/postMaterial",method=RequestMethod.POST)
    public Materiel postMaterial(@RequestBody Materiel compte) {
        return materielrepositor.save(compte);
    }

    @RequestMapping(value = "/materiel/{id_demande}",method =RequestMethod.GET )
    public List<Materiel> getProductsByNa(@PathVariable Long id_demande) {


        return  materielrepositor.find_id_demande(id_demande);

    }
    @RequestMapping(value = "/materielByUser/{username}",method =RequestMethod.GET )
    public List<Materiel> getProductsByNa(@PathVariable String username) {


        return  materielrepositor.findByUser(username);

    }

}
