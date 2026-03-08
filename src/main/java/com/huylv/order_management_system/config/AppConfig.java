package com.huylv.order_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String demoBean() {
        return "hello-bean";
    }

}