package pokemonmaster.cards;

import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;

public abstract class EvolvedPokemonCard extends PokemonCard {
    public EvolvedPokemonCard(CardInfo cardinfo, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
    }
}
