package com.huylv.order_management_system.presentation.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huylv.order_management_system.application.service.AsyncService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public String testAsync() {

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        asyncService.runTask();

        return "OK";
    }

    @GetMapping("/parallel")
    public String testParallel() {

        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncService.runTask("Task 1");
        CompletableFuture<String> task2 = asyncService.runTask("Task 2");

        // Đợi cả 2 task xong
        CompletableFuture.allOf(task1, task2).join();

        long end = System.currentTimeMillis();

        System.out.println("Total Time: " + (end - start));

        return "OK";
    }
}