package com.sinchan.webautomation.email;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    JavaMailSender javaMailSender;

   /* @Autowired
    MailerClient mailerClient;

    public void sendMailViaMailTrap(){
        Email email=  new Email()
                .setSubject("subject")
                .setFrom("Mister FROM <sinchan.saha@cognida.ai>")
                .addTo("Miss TO <sinchan.saha@cognida.ai>")
                .setBodyText("A demo Text")
                .setBodyHtml("<h1>This is Demo One</h1>");
        mailerClient.send(email);
    }*/

    public void sendMail(String to, String subject, String body) throws MessagingException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true);//true indicates multipart message
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);//true indicates body is html
        javaMailSender.send(message);
    }
}
