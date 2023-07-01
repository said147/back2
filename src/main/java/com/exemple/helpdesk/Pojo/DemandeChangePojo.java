package com.exemple.helpdesk.Pojo;

import com.exemple.helpdesk.models.MaterielChangeAncient;
import com.exemple.helpdesk.models.MaterielChangeNew;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class DemandeChangePojo {
    private Date date;
    private String status;
    private String tiquete_id;
    private String Type_Demande;
    private String DataURLEmploye  ;
     List<MaterielChangeAncient> materielChangeAncient;
     List<MaterielChangeNew> materielChangeNew;
}
