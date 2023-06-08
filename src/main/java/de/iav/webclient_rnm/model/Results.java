package de.iav.webclient_rnm.model;

import de.iav.webclient_rnm.model.RicknMortyCharacter;

import java.util.List;

public record Results(
        List<RicknMortyCharacter> results // Variable MUSS genauso heißen, wie in der API (results)
) {
}
