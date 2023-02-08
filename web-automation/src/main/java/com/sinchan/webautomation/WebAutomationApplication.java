package com.sinchan.webautomation;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.sinchan.webautomation")
@EnableAutoConfiguration
@EnableProcessApplication(value = "test-wf-engine")
public class WebAutomationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebAutomationApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebAutomationApplication.class);
	}


}
