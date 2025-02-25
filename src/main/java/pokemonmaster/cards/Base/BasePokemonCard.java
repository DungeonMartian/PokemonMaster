package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.cards.AbstractCard;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.CardInfo;

public abstract class BasePokemonCard extends BaseCard {
    protected AbstractCard evolve;
    protected AbstractCard NextEvo;
    public BasePokemonCard(CardInfo cardInfo) {
        super(cardInfo);
    }
    public Object evolve(){
        return this.evolve;}
    public Object NextEvo(){
        return this.NextEvo;}
    public void upgrade() {
        if (this.cardsToPreview != null && this.cardsToPreview.hasTag(CustomTags.POKEMON)) {
            this.cardsToPreview.upgrade();
        }
        super.upgrade();
    }
}
