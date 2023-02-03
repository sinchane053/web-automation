//package com.sinchan.webautomation.configuration;
//
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//public class ApplicationConfig {
//
//
//    /*@Bean(name = "jndiDataSource")
//    public DataSource getJndiDataSource(){
//        JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
//        return dsLookUp.getDataSource("java:comp/env/jdbc/testDb");
//    }
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate
//            (@Qualifier("jndiDataSource") DataSource ds){
//        return new JdbcTemplate(ds);
//    }*/
////    @Bean
////    @ConfigurationProperties("spring.datasource")
////    public DataSource dataSource() {
////        return DataSourceBuilder.create().build();
////    }
//
//
//}
