package com.example.aop.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class UserCreatedEvent extends ApplicationEvent {

    private Long id;

    public UserCreatedEvent(Long id) {
        super(id);
        this.id = id;
    }
    
}
