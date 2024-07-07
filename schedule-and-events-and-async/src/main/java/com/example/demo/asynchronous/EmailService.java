package com.example.demo.asynchronous;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    
    @Async
    Future<?> sendAsync(String from, String to);
}
