package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.cards.Lightning.Emolga;

public class EmolgaDrawAction extends AbstractGameAction {
    private AbstractCard card;

    public EmolgaDrawAction(AbstractCard card, int amount) {
        this.card = card;
        this.amount = amount;
    }

    public void update() {
        this.card.baseMagicNumber += this.amount;
        this.card.applyPowers();
        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
            if (c instanceof Emolga) {
                c.baseMagicNumber += this.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
            if (c instanceof Emolga) {
                c.baseMagicNumber += this.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c instanceof Emolga) {
                c.baseMagicNumber += this.amount;
                c.applyPowers();
            }
        }
        this.isDone = true;
    }
}