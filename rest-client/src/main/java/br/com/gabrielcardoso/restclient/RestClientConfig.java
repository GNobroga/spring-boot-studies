package br.com.gabrielcardoso.restclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    
    @Bean
    RestClient crudRestClient() {
        return RestClient.create("https://crudcrud.com/api/8169b7587fba432daafaa5c44cd32fab");
    }
    
    @Bean
    ApplicationRunner applicationRunner(CrudService crudService) {
        return args -> {
            var cat = crudService.create(new Cat("Bolinha", "Azuk", 2000D));
            System.out.println(cat.name());
        };
    }
}
