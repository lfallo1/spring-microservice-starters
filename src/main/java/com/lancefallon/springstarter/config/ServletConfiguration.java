package com.lancefallon.springstarter.config;

import com.lancefallon.springstarter.config.filter.CustomFilter;
import com.lancefallon.springstarter.config.model.AppProperties;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.beans.PropertyVetoException;

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
     * custom filter for all requests
     *
     * @return
     */
    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }

}
