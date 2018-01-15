package com.lancefallon.springstarter.config;

import com.lancefallon.springstarter.config.filter.DbFilter;
import com.lancefallon.springstarter.config.model.AppProperties;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import javax.servlet.Filter;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

/**
 * primary initialization class. creates various beans for email, velocity, and
 * filters
 *
 * @author lancefallon
 */
@Configuration
public class ServletConfiguration {

    @Autowired
    private AppProperties appConfig;

    @Bean(name = "dataSource")
    @Qualifier("primary")
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource driverManagerDataSource = new ComboPooledDataSource();
        try {
            driverManagerDataSource.setDriverClass(appConfig.getDbDriver());
            driverManagerDataSource.setJdbcUrl(appConfig.getDbUrl());
            driverManagerDataSource.setUser(appConfig.getDbUsername());
            driverManagerDataSource.setPassword(appConfig.getDbPassword());
            driverManagerDataSource.setMaxPoolSize(1000);
            driverManagerDataSource.setMinPoolSize(10);
            driverManagerDataSource.setMaxStatements(5);
            driverManagerDataSource.setStatementCacheNumDeferredCloseThreads(1);
            driverManagerDataSource.setNumHelperThreads(20);
        } catch (PropertyVetoException e) {
            String message = "An error has occurred.Please contact System Administrator";
            System.out.println(message + ": " + e.getMessage());
        }
        return driverManagerDataSource;
    }

    /**
     * configure velocity templating engine for emails
     *
     * @return
     * @throws VelocityException
     * @throws IOException
     */
    @Bean
    public VelocityEngine generateVelocityTemplate() throws VelocityException, IOException {
        VelocityEngineFactory factory = new VelocityEngineFactory();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();
    }

    /**
     * configure the email server
     *
     * @return
     */
    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(appConfig.getEmailHost());
        sender.setPort(appConfig.getEmailPort());
        return sender;
    }

    /**
     * add filter to set the db context on requests
     *
     * @return
     */
    @Bean
    public Filter dbFilter() {
        return new DbFilter();
    }

}
