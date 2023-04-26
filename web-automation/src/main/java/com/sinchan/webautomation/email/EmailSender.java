package com.sinchan.webautomation.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        FileSystemResource attachmentResource = new FileSystemResource
                (new File("/reports/daily_health_check_report.txt"));
        if(!attachmentResource.exists()){
            System.out.println("Unable to find the required file");
        }
        helper.addAttachment("Daily Health Check Report", attachmentResource.getFile());
        javaMailSender.send(message);
    }

    public String getCurrDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
        Date date = new Date();
        return sdf.format(date);

    }
}
