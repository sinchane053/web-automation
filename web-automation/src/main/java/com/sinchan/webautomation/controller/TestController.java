package com.sinchan.webautomation.controller;

import com.sinchan.webautomation.delegates.StartDelegate;
import com.sinchan.webautomation.email.EmailSender;
import com.sinchan.webautomation.entities.City;
import com.sinchan.webautomation.reports.ReportGenerationService;

import com.sinchan.webautomation.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    StartDelegate startDelegate;

    @Autowired
    ReportGenerationService reportService;



    @Autowired
    EmailSender emailSender;
    @GetMapping(value = "/test")
    public String test(){
        return "Service is deployed at " +
                new Timestamp(System.currentTimeMillis()) + ", currently it is up.";
    }

    @GetMapping(value = "/cities")
    public List<City> getAllCities() {
        return testService.getAllCities();
    }

    @PostMapping(value = "/startWfById")
    public String startWorkFlowByKey(@RequestParam String processId) throws Exception {
        System.out.println("Started");
        return startDelegate.startProcessInstanceByKey(processId);
    }


//    @Scheduled(fixedRate = 3000)
    @PostMapping(value = "/sendEmailTest")
    public void automateEmailSender() throws MessagingException {
        emailSender.sendEmailWithButton();
    }

    @PostMapping(value = "/sendEmail")
    public String sendEmail() throws MessagingException {
        System.out.println("starting the sending process");
        String subject = "Demo" + emailSender.getCurrDateTime();
        emailSender.sendMail("sinchan.saha99@gmail.com",subject
        ,"<h1>This is a test email</h1>\n" +
                        "<h2 style=\"background-color:#FF0000\">New Incident Found</h2>\n" +
                        "<p>This email contains the report for the daily error report for workflow incidents</p>");
//        emailSender.sendMailViaMailTrap();

        return "Email Sent....";

    }

    @PostMapping(value = "/report")
    public String generateReport() throws IOException , FileNotFoundException{
        reportService.generateReport();
        reportService.generateTextReport();
        return  "Printing done";
    }
//    @GetMapping(value = "/getAllIncidents")
//    public List<String> getIncidents() throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
//        return camundaDaoImpl.getIncident();
//    }

}
