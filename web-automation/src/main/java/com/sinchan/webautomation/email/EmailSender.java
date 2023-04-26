package com.sinchan.webautomation.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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
    public void sendEmailWithButton() {
        // Replace with the actual SMTP server and email account information
        String smtpServer = "sandbox.smtp.mailtrap.io";
        String username = "f599c2b934bc37";
        String password = "665f8bbe9b6864";

        // Replace with the actual email content and recipient information
        String from = "user@example.com";
        String to = "recipient@example.com";
        String subject = "Test Email with Button";

        // Replace with the actual URL and text for the button
        String buttonUrl = "https://example.com";
        String buttonText = "Click me!";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", smtpServer);
        properties.setProperty("spring.mail.port","2525");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("spring.mail.properties.mail.smtp.starttls.enable","true");
        properties.setProperty("spring.mail.username",username);
        properties.setProperty("spring.mail.password",password);


        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            // Create a MimeMultipart object to hold the email content
            MimeMultipart multipart = new MimeMultipart();

            // Create a MimeBodyPart object for the text content of the email
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("This is a test email with a button. Click the button below:");

            // Create a MimeBodyPart object for the button
            MimeBodyPart buttonPart = new MimeBodyPart();
            String buttonHtml = String.format("<button onclick=\"window.location.href='%s'\">%s</button>", buttonUrl, buttonText);
            buttonPart.setContent(buttonHtml, "text/html");

            // Add the text and button parts to the MimeMultipart object
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(buttonPart);

            // Set the MimeMultipart object as the content of the email
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException ex) {
            System.err.println("Error sending email: " + ex.getMessage());
        }
    }

}
