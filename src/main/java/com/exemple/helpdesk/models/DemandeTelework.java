package com.exemple.helpdesk.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeTelework implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demandeTelework;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String adresse ;
    private String status  ;
    private String Type_Demande;
    private String DataURLEmploye  ;
    private String DataURLCheker  ;
    @OneToMany(targetEntity = MaterielTelework.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idmt",referencedColumnName = "id_demandeTelework")

    private List<MaterielTelework> materielTelework;
    @ManyToOne (cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id")

    private User user;
}
