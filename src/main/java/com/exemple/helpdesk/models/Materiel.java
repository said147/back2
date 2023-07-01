package com.exemple.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Getter
@Setter

@AllArgsConstructor
public class Materiel  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materiel;

    /*private Long id_demande;*/
    private  String equipement;

    private  String model;

    private  String serial;

    private  String comment;
    /*@ManyToOne*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idm")

@JsonIgnore

    private Demande demande;

    public Long getId_materiel() {
        return id_materiel;
    }

    public void setId_materiel(Long id_materiel) {
        this.id_materiel = id_materiel;
    }



    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Materiel(String equipement, String model, String serial, String comment) {
        this.equipement = equipement;
        this.model = model;
        this.serial = serial;
        this.comment = comment;

    }

    public Materiel() {
        super();
    }
}
