package com.example.demo.events;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class Listener {
    
    //@EventListener(condition = "#event.type eq 'value here!'") --> Listen with condition
    @EventListener
    void onSendNotificationEvent(SendNotificationEvent event) {
        System.out.println("Event occurring");
        System.out.println(event.getType());
    }

}
