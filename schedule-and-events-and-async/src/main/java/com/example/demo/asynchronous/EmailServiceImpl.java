package com.example.demo.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class EmailServiceImpl implements EmailService {

    @Override
    public Future<?> sendAsync(String from, String to) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println("Email sending from %s to %s".formatted(from, to));
        return CompletableFuture.completedFuture("Ready");
    }
    
}
