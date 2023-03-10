/*
package com.sinchan.webautomation.configuration;


import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.ProcessEngineService;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.spring.application.SpringProcessApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.sinchan")
public class ApplicationConfig {

    //comment out the jndi part when using embedded tomcat
    @Bean(name = "jndiDataSource")
    public DataSource getJndiDataSource() {
        JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
        return dsLookUp.getDataSource("java:comp/env/jdbc/testDb");
    }

    //local db
    */
/*@Bean(name = "localdatasource")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*//*

    //set datasource depending on the variable
    @Bean(name = "jndiDataSource")
    public JdbcTemplate getJdbcTemplate(@Qualifier("localdatasource") DataSource ds) {
        return new JdbcTemplate(ds);
    }


    //Camunda Beans
    @Bean
    public ProcessEngineService processEngineService() {
        return BpmPlatform.getProcessEngineService();
    }

    @Bean(destroyMethod = "")
    public ProcessEngine processEngine() {
        return BpmPlatform.getDefaultProcessEngine();
    }

    @Bean
    public SpringProcessApplication processApplication() {
        return new SpringProcessApplication();
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    @Bean
    public ManagementService managementService(ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }


}
*/
