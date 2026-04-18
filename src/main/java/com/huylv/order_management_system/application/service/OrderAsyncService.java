package com.huylv.order_management_system.application.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderAsyncService {

    @Async("taskExecutor")
    public CompletableFuture<Integer> countOrders() {

        System.out.println("countOrders - " + Thread.currentThread().getName());

        sleep(2000);

        return CompletableFuture.completedFuture(120);
    }

    @Async("taskExecutor")
    public CompletableFuture<Long> calculateRevenue() {

        System.out.println("calculateRevenue - " + Thread.currentThread().getName());

        sleep(3000);

        return CompletableFuture.completedFuture(5000000L);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}