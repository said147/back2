package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class UserComtroller {
    @Autowired
    private UserRepository demanderepositor;

    @RequestMapping( value="/users",method= RequestMethod.GET)
    public List<User> getContacts(){

        return demanderepositor.findAll();
    }


    @RequestMapping(value = "/user/{id}",method =RequestMethod.GET )
    public Optional<User> getProductsByNa(@PathVariable Long id) {


        return  demanderepositor.findById(id);

    }


}
