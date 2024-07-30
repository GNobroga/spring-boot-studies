package io.gnobroga.spring_webflux_essentials.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "playlists")
@AllArgsConstructor 
@Data
@NoArgsConstructor
public class Playlist {

    @Id 
    private String id;

    private String name;
    
    public Playlist(String name) {
        this.name = name;
    }
}
