package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.models.Email;
import com.exemple.helpdesk.models.Mail;
import com.exemple.helpdesk.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderMailServiceImpl {
    @Autowired
    /*send email simple*/
    private JavaMailSender mailSender;
    @Autowired
    private MailRepository mailRepository;
    public long sendEmail(Mail email)  {
        SimpleMailMessage msg = new SimpleMailMessage();



        msg.setTo(email.getDestinaire());
        msg.setFrom("saidraggad822@gmail.com");

        /* System.out.println(j.getNomFour());*/

        msg.setSubject("Alertes helpdesk");
        msg.setText(email.getMassage());
        mailSender.send(msg);
        return mailRepository.save(email).getId();
    }
}
