package be.mobyus.controller;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * Adding the config for H2 console with url: /console
 * Default Spring boot settings:
 * Driver: Org.h2.Driver
 * Use JDBC-url: jdbc:h2:mem:testdb
 * User: SA
 * Password: 
 * @author Stijn
 *
 */
@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}