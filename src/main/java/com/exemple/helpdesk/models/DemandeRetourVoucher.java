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
public class DemandeRetourVoucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demandeRetour;
    private String Type_Demande;
    private String Reason  ;
    private String status  ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_retour;
    private String name_verified  ;
    private String tiquete_id;
    private String DataURLEmploye;
    private String DataURLChecker;

    @OneToMany(targetEntity = MaterielRetour.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idmr",referencedColumnName = "id_demandeRetour")

    private List<MaterielRetour> materielRetour;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
