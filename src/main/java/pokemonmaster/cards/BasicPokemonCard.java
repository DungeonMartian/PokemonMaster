package pokemonmaster.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;


public abstract class BasicPokemonCard extends PokemonCard {
    private PokemonCard nextEvolution;
    private PokemonCard finalEvolution;
    public BasicPokemonCard(CardInfo cardinfo, PokemonCard nextEvolution, PokemonCard finalEvolution, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.nextEvolution = nextEvolution;
        this.finalEvolution = finalEvolution;
        // if this,finalEvolution is not None
        if (this.finalEvolution != null) {
            this.cardsToPreview = this.finalEvolution.makeCopy();
        }
        // if this.nextEvolution is not None
        if (this.nextEvolution != null) {
            purgeOnUse = true;
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onUse(p, m);
        // if this.nextEvolution is not None
        if (this.nextEvolution != null) {
            addToBot(new MakeTempCardInDiscardAction(this.nextEvolution.makeCopy(), 1));
        }
    }
    // define abstract method onUse
    public abstract void onUse(AbstractPlayer p, AbstractMonster m);
}

