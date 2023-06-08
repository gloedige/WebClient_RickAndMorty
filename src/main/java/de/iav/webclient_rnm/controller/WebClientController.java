package de.iav.webclient_rnm.controller;

import de.iav.webclient_rnm.service.WebClientService;
import de.iav.webclient_rnm.model.RicknMortyCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class WebClientController {
    private final WebClientService webClientService;

    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping("/{id}")
    public RicknMortyCharacter getSingleCharacter(@PathVariable String id){
        return webClientService.getSingleCharacterById(id);
    }

    @GetMapping()
    public List<RicknMortyCharacter> getAllCharacters(){

        return webClientService.getAllCharacters();
    }
}
