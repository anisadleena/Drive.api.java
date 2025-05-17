package com.example.Drive.api.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        System.out.println("EmailService: Sending email to " + to);
        System.out.println("EmailService: Subject: " + subject);
        System.out.println("EmailService: Text: " + text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mocha123test@gmail.com"); 
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
       
         try {
            mailSender.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (Exception e) {
            System.out.println("Failed to send email to " + to);
        }
    }
}
