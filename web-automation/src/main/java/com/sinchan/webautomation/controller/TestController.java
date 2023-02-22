package com.sinchan.webautomation.controller;

import com.sinchan.webautomation.delegates.StartDelegate;
import com.sinchan.webautomation.email.EmailSender;
import com.sinchan.webautomation.entities.City;
import com.sinchan.webautomation.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    StartDelegate startDelegate;

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
    @PostMapping(value = "/sendEmail")
    public String sendEmail() throws MessagingException {
        System.out.println("starting the sending process");
        emailSender.sendMail("sinchan.saha@cognida.ai","Test-1"
        ,"<h2>This Email Signifies that this is a </h2>" +
                        "<h1> TEST </h1>");
//        emailSender.sendMailViaMailTrap();

        return "Email Sent....";

    }
}
