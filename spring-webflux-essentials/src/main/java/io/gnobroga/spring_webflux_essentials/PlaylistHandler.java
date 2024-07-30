package io.gnobroga.spring_webflux_essentials;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;

import io.gnobroga.spring_webflux_essentials.document.Playlist;
import io.gnobroga.spring_webflux_essentials.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PlaylistHandler {
    
    private final PlaylistService service;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(service.findById(request.pathVariable("id")), Playlist.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(Playlist.class)
            .flatMap(record -> savePlaylist(record, request));
    }
    
    private Mono<ServerResponse> savePlaylist(Playlist record, ServerRequest request) {
        System.out.println(record.getName());
        return service.save(record)
            .flatMap(playlist -> {
                final var uri = UriComponentsBuilder.fromPath(request.path())
                    .path("/{id}")
                    .buildAndExpand(playlist.getId()).toUri();
    
                return ServerResponse.created(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(playlist), Playlist.class);
            });
    }
    
}
