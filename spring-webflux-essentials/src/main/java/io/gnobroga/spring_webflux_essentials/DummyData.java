package io.gnobroga.spring_webflux_essentials;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import io.gnobroga.spring_webflux_essentials.document.Playlist;
import io.gnobroga.spring_webflux_essentials.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class DummyData implements ApplicationRunner {

    private final PlaylistRepository repository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository
            .deleteAll()
            .thenMany( 
                Flux.just("Justin Baby", "Ketlin do Paraguai")
                .map(Playlist::new) 
                .flatMap(repository::save)
            ).subscribe();

    }
    
}
