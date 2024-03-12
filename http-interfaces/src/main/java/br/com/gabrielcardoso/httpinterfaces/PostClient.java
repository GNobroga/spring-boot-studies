package br.com.gabrielcardoso.httpinterfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/posts")
public interface PostClient {
    
    @GetExchange
    List<Post> get();

    @GetExchange("/{id}")
    Post get(@PathVariable Long id);

    @PostExchange("/{id}")
    Post create(@RequestBody Post post);
}
