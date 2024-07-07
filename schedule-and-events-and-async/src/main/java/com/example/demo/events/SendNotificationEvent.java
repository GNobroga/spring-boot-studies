package com.example.demo.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class SendNotificationEvent extends ApplicationEvent {

    private Type type;

    public enum Type {
        EMAIL,
        SMS;
    }

    public SendNotificationEvent(Object source, Type type) {
        super(source);
        this.type = type;
    }
    
}
