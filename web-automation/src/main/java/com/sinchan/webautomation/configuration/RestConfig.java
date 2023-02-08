package com.sinchan.webautomation.configuration;

import org.camunda.bpm.spring.boot.starter.rest.CamundaJerseyResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/resources")
public class RestConfig extends CamundaJerseyResourceConfig {

}
