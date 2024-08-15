package com.example.aop.services;

import java.util.Map;
import java.util.Random;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aop.events.UserCreatedEvent;
import com.example.aop.models.User;
import com.example.aop.models.embedded.NameEmbedded;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final EntityManager manager;

    private final ApplicationEventPublisher publisher;

    @Transactional
    public void populate() {
        final var names = Map.of("Gabriel", "Cardoso", "Pedro", "Marcos", "Antônio", "José");
			for (var set: names.entrySet()) {
				final var user = new User();
                user.setId(new Random().nextLong(5000));
				user.setName(new NameEmbedded(set.getKey(), set.getValue()));
				manager.persist(user);
                publisher.publishEvent(new UserCreatedEvent(user.getId()));
		} 

        throw new RuntimeException("OII");
    }
}
