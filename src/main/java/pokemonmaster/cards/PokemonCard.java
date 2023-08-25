package pokemonmaster.cards;

import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;

public abstract class PokemonCard extends BaseCard{

    private final CardTags _pokemonType;
    public PokemonCard(CardInfo cardInfo, CardTags pokemonType) {
        super(cardInfo);
        this._pokemonType = pokemonType;
        this.tags.add(CustomTags.POKEMON);
        this.tags.add(this._pokemonType);
    }
    // public void SetCardTypingBackground()
    // {
    //     // TODO: make this.pokemonType the background of the card
    //     // make this.pokemonType the background of the card
    //     // if it's psychic, make the background purple
    //     // if it's grass, make the background green
    //     // etc
    //     // case PSYCHIC:
    //     //     this.setBackgroundTexture("img/512/bg_pokemon_psychic.png", "img/1024/bg_pokemon_psychic.png");
    //     //     break;
    // }
}
