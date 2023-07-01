package com.exemple.helpdesk.Pojo;

import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.models.Tiquete;
import com.exemple.helpdesk.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class DemandePojo {
    private Date date;

    private String Allocation_motive ;


    private String status;
    /*private List<Materiel> materiel;*/

   /* private  String equipement;

    private  String model;

    private  String serial;


    private  String comment;*/
   private String tiquete_id;
    private String DataURLEmploye  ;
   List<Materiel> materiel;

}
