package io.gnobroga.spring_webflux_essentials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.gnobroga.spring_webflux_essentials.PlaylistHandler;

@Configuration
public class PlaylistRouter {
    
    @Bean
    RouterFunction<ServerResponse> routes(PlaylistHandler playlistHandler) {
        return RouterFunctions.route(
            RequestPredicates.GET("/playlists"), playlistHandler::getAll
        ).andRoute(
            RequestPredicates.GET("/playlists/{id}"),
            playlistHandler::getById
        ).andRoute(
            RequestPredicates.POST("/playlists").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
            playlistHandler::create
        );
    }
}
