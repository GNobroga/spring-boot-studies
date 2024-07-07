package com.example.demo.schedule;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {
    
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void scheduledFixedDelayTask() {
        System.out.println("Tarefa executada");
    }
}
