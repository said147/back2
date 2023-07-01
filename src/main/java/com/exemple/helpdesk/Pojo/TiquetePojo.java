package com.exemple.helpdesk.Pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TiquetePojo {
    private Date date;
    private String Type_Request  ;
    private String status;
    private String Message ;
}
