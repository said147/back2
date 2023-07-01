package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class EmailSenderServiceImpl {
    @Autowired
    /*send email simple*/
    private JavaMailSender mailSender;
    public void sendEmail(Email email)  {
        SimpleMailMessage mail = new SimpleMailMessage();



            mail.setTo("saidraggad822@gmail.com");
            mail.setFrom(email.getEmail());

                /* System.out.println(j.getNomFour());*/

                    mail.setSubject("Alertes helpdesk");
                    mail.setText("Hello "+"  "+
                            "Bravo pour ce premier   ");




        mailSender.send(mail);
        }



    }

