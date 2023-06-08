package de.iav.webclient_rnm.service;

import de.iav.webclient_rnm.model.Results;
import de.iav.webclient_rnm.model.RicknMortyCharacter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
@Service
public class WebClientService {
    private final WebClient webClient; //= WebClient.create("https://rickandmortyapi.com/api/character/");
    //url wird nicht mehr hart gecoded, sondern über @Value dynamisch zugewiesen
    public WebClientService(@Value("${rickandmorty.url}") String url) {
        this.webClient = WebClient.create(url);
    }

    public RicknMortyCharacter getSingleCharacterById(String id) {
        ResponseEntity<RicknMortyCharacter> responseEntity = webClient.get()
                .uri(id)
                .retrieve()
                .toEntity(RicknMortyCharacter.class)
                .block();

        return Objects.requireNonNull(responseEntity).getBody();
    }
    public List<RicknMortyCharacter> getAllCharacters() {
        Results responseEntity = webClient.get()
                .retrieve()
                .toEntity(Results.class)
                .block()
                .getBody();
        Objects.requireNonNull(responseEntity);
        return responseEntity.results();
    }


}
