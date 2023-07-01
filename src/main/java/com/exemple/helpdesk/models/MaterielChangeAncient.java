package com.exemple.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterielChangeAncient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materielChangeAncient;

    /*private Long id_demande;*/
    private  String equipement;

    private  String model;

    private  String serial;
    private  String  level;
    @JsonIgnore

    private DemandeChange demandeChange;
}
