package com.huylv.order_management_system.application.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("taskExecutor")
    public CompletableFuture<String> runTask() {

        System.out.println("Async Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000); // giả lập xử lý lâu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture("Done");
    }

    @Async("taskExecutor")
    public CompletableFuture<String> runTask(String taskName) {

        System.out.println(taskName + " - Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(taskName + " - Done");

        return CompletableFuture.completedFuture(taskName + " Done");
    }
}