package com.lancefallon.springstarter.config.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * helper class to store app properties. this class should be created as a bean,
 * and fill the properties
 *
 * @author lancefallon
 */
@Component
public class AppProperties {

    @Value("${email.host}")
    private String emailHost;

    @Value("${email.port}")
    private int emailPort;

    @Value("${datasource.url}")
    private String dbUrl;

    @Value("${datasource.username}")
    private String dbUsername;

    @Value("${datasource.password}")
    private String dbPassword;

    @Value("${datasource.driver-class-name}")
    private String dbDriver;

    @Value("${flyway.locations}")
    private String flywayLocations;

    public String getEmailHost() {
        return emailHost;
    }

    public int getEmailPort() {
        return emailPort;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getFlywayLocations() {
        return flywayLocations;
    }
}
