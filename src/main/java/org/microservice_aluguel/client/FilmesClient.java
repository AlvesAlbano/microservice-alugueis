package org.microservice_aluguel.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FilmesClient {

    private final RestClient restClient = RestClient.create();
    private final String urlBase = "http://filmes-api-production.up.railway.app/";

    public String getFilmeById(Integer id){
        return restClient
                .get()
                .uri(urlBase + "filmes/" + id)
                .retrieve()
                .body(String.class);
    }
}