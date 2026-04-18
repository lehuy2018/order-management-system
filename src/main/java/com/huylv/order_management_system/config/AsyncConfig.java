package com.huylv.order_management_system.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);     // số thread luôn giữ
        executor.setMaxPoolSize(4);      // tối đa
        executor.setQueueCapacity(10);   // hàng đợi

        executor.setThreadNamePrefix("Async-");

        executor.initialize();
        return executor;
    }
}