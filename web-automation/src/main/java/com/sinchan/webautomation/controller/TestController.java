package com.sinchan.webautomation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String test(){
        return "Service is deployed at " +
                new Timestamp(System.currentTimeMillis()) + ", currently it is up.";
    }

}
