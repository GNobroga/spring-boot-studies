package com.example.aop.consumers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.aop.events.UserCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserCreatedConsumer {
    
    @EventListener()
    public String listen(UserCreatedEvent event) {
        log.info("Usuario com id {}", event.getId());
        return "Usuario " + event.getId();
    }
}
