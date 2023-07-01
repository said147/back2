package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.models.Email;
import com.exemple.helpdesk.models.Mail;
import com.exemple.helpdesk.service.impl.EmailSenderServiceImpl;
import com.exemple.helpdesk.service.impl.SenderMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MessController {
    @Autowired
    private EmailSenderServiceImpl emailService;
    @Autowired
    private SenderMailServiceImpl senderMailServiceImpl;

    //some other code

    @PostMapping(value = "/email")
    public ResponseEntity<Email> enviarEmail(@RequestBody Email email){
        try {
            emailService.sendEmail(email);
            return new ResponseEntity<>(email,  HttpStatus.OK);
        } catch( MailException e){
            /*return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);*/
            emailService.sendEmail(email);
            return new ResponseEntity<>(email,  HttpStatus.OK);

        }



    }
    @PostMapping(value = "/mails")
    public long enviarEmail(@RequestBody Mail email){
        return senderMailServiceImpl.sendEmail(email);

}
}
