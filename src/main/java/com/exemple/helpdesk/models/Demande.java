package com.exemple.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demande  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demande;
    @Column(name = "date")

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String Allocation_motive ;
    private String status;
    private String tiquete_id;
    private String DataURLEmploye  ;
    @OneToMany(targetEntity = Materiel.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idm",referencedColumnName = "id_demande")

    private List<Materiel> materiel;




   /* @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "tiquete_id")
    private Tiquete tiquete;*/


    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    public Long getId_demande() {
        return id_demande;
    }

    public void setId_demande(Long id_demande) {
        this.id_demande = id_demande;
    }






}
