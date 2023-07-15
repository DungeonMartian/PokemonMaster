package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

public abstract class BasePokemonCard extends BaseCard {
    protected AbstractCard evolve;
    public BasePokemonCard(CardInfo cardInfo) {
        super(cardInfo);

    }
    public Object evolve(){
        return this.evolve;}
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

        addToBot(new EvolveActionCombat(this.evolve,"discard"));
    }
}
