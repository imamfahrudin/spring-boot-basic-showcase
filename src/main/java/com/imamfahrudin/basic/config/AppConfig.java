package com.imamfahrudin.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class for the basic showcase application.
 * Defines beans and configuration for the application context.
 */
@Configuration
public class AppConfig {

    /**
     * Bean providing the application name.
     * @return the name of the application
     */
    @Bean
    public String applicationName() {
        return "Imam's Spring Showcase";
    }

}