package com.example.demo.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import com.example.demo.events.SendNotificationEvent.Type;

@Component
@RequiredArgsConstructor
public class Publisher {
    
    private final ApplicationEventPublisher publisher;

    public void execute(Type type) {
        publisher.publishEvent(new SendNotificationEvent(this, type));
    }
}
