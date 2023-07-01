package com.exemple.helpdesk.Pojo;

import com.exemple.helpdesk.models.MaterielRetour;
import com.exemple.helpdesk.models.MaterielTelework;
import com.exemple.helpdesk.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DemandeTeleworkPojo {
    private Date date;
    private String adresse ;
    private String status  ;
    private String Type_Demande;
    private String DataURLEmploye  ;
    private String DataURLCheker  ;
    List<MaterielTelework> materielTelework;


}
