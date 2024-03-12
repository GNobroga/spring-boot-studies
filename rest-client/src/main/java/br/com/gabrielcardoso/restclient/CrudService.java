package br.com.gabrielcardoso.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CrudService {

    @Autowired
    private RestClient restClient;

    public Cat create(Cat cat) {
        return restClient.post()   
            .uri("/cats")
            .contentType(APPLICATION_JSON)
            .accept(APPLICATION_JSON)
            .body(cat)
            .retrieve()
            .body(Cat.class);
    }

    
}
