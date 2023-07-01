package com.exemple.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeDepart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demandeDepart;
    private String Matricule  ;
    private String Activite ;
    private String Resp_hier;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_Entree;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_Depart;
    private String Email_perso;
    private String Tel_perso;
    private boolean Theme_RHi;
    private String comment_RHi;

    private boolean Theme_IT;
    private String comment_IT;

    private boolean Theme_RH;
    private String comment_RH;

    private boolean Theme_FINANCES;
    private String comment_FINANCES;

    private boolean Theme_AMG;
    private String comment_AMG;

    private String Type_Demande;

    private String status  ;
    private String DataURL  ;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
