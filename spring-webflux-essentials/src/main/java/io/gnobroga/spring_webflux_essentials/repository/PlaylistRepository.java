package io.gnobroga.spring_webflux_essentials.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import io.gnobroga.spring_webflux_essentials.document.Playlist;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PlaylistRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Flux<Playlist> findAll() {
        final Query query = new Query();
        return reactiveMongoTemplate.find(query, Playlist.class);
    }

    public Mono<Playlist> findById(String id) {
        return reactiveMongoTemplate.findById(id, Playlist.class);
    }

    public Mono<Playlist> save(Playlist record) {
        return reactiveMongoTemplate.save(record);
    }

    public Flux<Void> deleteAll() { 
        findAll().toStream().forEach(playlist -> {
            final var query = new Query(); 
            query.addCriteria(Criteria.where("id").is(playlist.getId()));
            reactiveMongoTemplate.findAndRemove(query, Playlist.class).block();
        });
        return Flux.empty(); 
    }
}  
