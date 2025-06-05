package org.microservice_aluguel.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UsuarioClient {
    private final RestClient restClient = RestClient.create();
    private final String urlBase = "";

    public String getUsuarioById(Integer id){
        return restClient
                .get()
                .uri(urlBase + "filmes/" + id)
                .retrieve()
                .body(String.class);
    }
}