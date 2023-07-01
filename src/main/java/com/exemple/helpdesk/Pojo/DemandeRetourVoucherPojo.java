package com.exemple.helpdesk.Pojo;


import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.models.MaterielRetour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class DemandeRetourVoucherPojo {

    private String Reason ;
    private String status;
    private String Type_Demande;
    private Date date_retour;
    private String name_verified  ;
    private String tiquete_id  ;
    private String DataURLEmploye;
    private String DataURLChecker;
    List<MaterielRetour> materielRetour;


}
