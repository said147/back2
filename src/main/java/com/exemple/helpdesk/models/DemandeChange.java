package com.exemple.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class DemandeChange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demandeChange;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String Type_Demande;

    private String status;
    private String tiquete_id;
    private String DataURLEmploye  ;
    @OneToMany(targetEntity = MaterielChangeAncient.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idmca",referencedColumnName = "id_demandeChange")

    private List<MaterielChangeAncient> materielChangeAncient;
    @OneToMany(targetEntity = MaterielChangeNew.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idmca",referencedColumnName = "id_demandeChange")

    private List<MaterielChangeNew> materielChangeNew;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
