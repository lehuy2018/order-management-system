package com.huylv.order_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demonstrates the difference between auto-configuration and manual Bean configuration.
 *
 * Spring Boot's @SpringBootApplication enables auto-configuration via @EnableAutoConfiguration,
 * which automatically registers Beans based on classpath dependencies (e.g., DataSource,
 * JpaRepositories). The Beans below are manually declared with @Bean, giving full control
 * over instantiation and wiring — useful when auto-config defaults are insufficient.
 */
@Configuration
public class AppConfig {

    /**
     * Manually configured Bean — Spring will NOT auto-create this.
     * Contrast with DataSource, which Spring Boot auto-configures from application.yml.
     */
    @Bean
    public String appName() {
        return "Order Management System";
    }
}
