package io.gnobroga.spring_webflux_essentials.service;

import org.springframework.stereotype.Service;

import io.gnobroga.spring_webflux_essentials.document.Playlist;
import io.gnobroga.spring_webflux_essentials.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository repository;


    @Override
    public Flux<Playlist> findAll() {
       return repository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public <T extends Playlist> Mono<Playlist> save(T record) {
       return repository.save(record);
    }
    
}
