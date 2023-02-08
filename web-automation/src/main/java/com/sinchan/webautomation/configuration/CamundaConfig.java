package com.sinchan.webautomation.configuration;

import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.sinchan")
public class CamundaConfig {

    @Bean(name = "jndiDataSource")
    public DataSource getJndiDataSource() {
        JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
        return dsLookUp.getDataSource("java:comp/env/jdbc/testDb");
    }
   /* @Bean(name = "localdatasource")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getJndiDataSource());
    }
    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

        config.setDataSource(getJndiDataSource());
        config.setTransactionManager(transactionManager());
        config.setIdGenerator(new StrongUuidGenerator());
        config.setDatabaseSchemaUpdate("true");
        config.setHistory("full");
        config.setJobExecutorActivate(true);
        config.setDefaultSerializationFormat("application/json");
        config.setCreateIncidentOnFailedJobEnabled(true);
        config.setJobExecutorActivate(true);
        config.setMetricsEnabled(false);


        config.setJobExecutorDeploymentAware(true);
        return config;

    }


   /* @Bean
    public ProcessEngineFactoryBean processEngine() {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
        return factoryBean;
    }*/

/*    @Bean
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
    }*/
}
