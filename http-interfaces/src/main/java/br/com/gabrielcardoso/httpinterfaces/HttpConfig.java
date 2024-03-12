package br.com.gabrielcardoso.httpinterfaces;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpConfig {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Bean
    PostClient postClient() {
        var webClient = WebClient.builder()
            .baseUrl(BASE_URL)
            .build();
        return HttpServiceProxyFactory
            .builder(WebClientAdapter.create(webClient))
            .build()
            .createClient(PostClient.class);
    }

    @Bean
    ApplicationRunner applicationRunner(PostClient postClient) {
        return args -> {
            for (var post: postClient.get()) {
                System.out.println(post);
            }
        };
    }

}
