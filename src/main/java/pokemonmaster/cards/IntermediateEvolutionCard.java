package pokemonmaster.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

// import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;

public abstract class IntermediateEvolutionCard extends EvolvedPokemonCard {
    // private PokemonCard preevolution;
    private PokemonCard finalEvolution;
    public IntermediateEvolutionCard(CardInfo cardinfo, PokemonCard finalEvolution, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        // this.preevolution = preevolution;
        this.finalEvolution = finalEvolution;
        // add preview
        this.cardsToPreview = this.finalEvolution.makeCopy();
        purgeOnUse = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onUse(p, m);
        addToBot(new MakeTempCardInDiscardAction(this.finalEvolution.makeCopy(), 1));
        }

    public abstract void onUse(AbstractPlayer p, AbstractMonster m);

    // public void devolve(AbstractPlayer p, AbstractMonster m) {
    //     addToBot(new MakeTempCardInDiscardAction(this.preevolution, 1));
    //     // TODO purge

    // }
}