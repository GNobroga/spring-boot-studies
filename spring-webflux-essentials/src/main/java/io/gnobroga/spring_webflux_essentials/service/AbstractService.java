package io.gnobroga.spring_webflux_essentials.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbstractService<T> {
    
    Flux<T> findAll();

    Mono<T> findById(String id);

    <R extends T> Mono<T> save(R record);
}
