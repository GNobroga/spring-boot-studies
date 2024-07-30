package io.gnobroga.spring_webflux_essentials.controller;

import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gnobroga.spring_webflux_essentials.document.Playlist;
import io.gnobroga.spring_webflux_essentials.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/playlist-stream")
@RequiredArgsConstructor
public class PlaylistStreamController {

    private final PlaylistService service;
    

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> get() {
        Flux<Long> interval = Flux.create(emitter -> {
            IntStream.range(0, 6)
            .mapToLong(number -> number)
            .forEach(emitter::next);
            emitter.complete();
        });
        Flux<Playlist> events = service.findAll();
        return Flux.zip(interval, events);
    }
    
}
