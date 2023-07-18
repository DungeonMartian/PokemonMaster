package pokemonmaster.cards;

// import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

// import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;

public abstract class FinalEvolutionCard extends EvolvedPokemonCard {
    // private PokemonCard preevolution;
    public FinalEvolutionCard(CardInfo cardinfo, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        // this.preevolution = preevolution;
        // purgeOnUse = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onUse(p, m);
        }

    public abstract void onUse(AbstractPlayer p, AbstractMonster m);

    // public void devolve(AbstractPlayer p, AbstractMonster m) {
    //     addToBot(new MakeTempCardInDiscardAction(this.preevolution, 1));
    //     // TODO purge

    // }
}