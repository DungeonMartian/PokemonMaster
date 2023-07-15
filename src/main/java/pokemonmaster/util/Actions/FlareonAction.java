package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class FlareonAction extends AbstractGameAction {


    private final DamageInfo info;

    public FlareonAction (AbstractCreature target, DamageInfo info, Integer number){
        this.info = info;
        setValues(target, info);
        this.amount=number;
        this.actionType = ActionType.DAMAGE;

    }

    @Override
    public void update() {

            if (AbstractDungeon.player.drawPile.size() < this.amount) {
                int TODO = AbstractDungeon.player.drawPile.size();
                for (int i = 0; i < TODO; i++) {
                    AbstractCard BURN = AbstractDungeon.player.drawPile.getNCardFromTop(i);
                    addToBot(new ExhaustSpecificCardAction(BURN, AbstractDungeon.player.drawPile));
                    if (BURN.type == AbstractCard.CardType.SKILL || BURN.type == AbstractCard.CardType.STATUS) {
                        this.target.damage(this.info);
                    }
                }

            }

            if (AbstractDungeon.player.drawPile.size() >= this.amount) {
                for (int i = 0; i < this.amount; i++) {
                    AbstractCard BURN = AbstractDungeon.player.drawPile.getNCardFromTop(i);
                    addToBot(new ExhaustSpecificCardAction(BURN, AbstractDungeon.player.drawPile));
                    if (BURN.type == AbstractCard.CardType.SKILL || BURN.type == AbstractCard.CardType.STATUS) {
                        this.target.damage(this.info);
                    }
                }



        }
this.isDone=true;
    }
}
