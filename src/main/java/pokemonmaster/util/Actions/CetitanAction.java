package pokemonmaster.util.Actions;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.CustomTags;

import java.util.function.Predicate;


public class CetitanAction extends AbstractGameAction {
    public CetitanAction(Integer number){
    this.amount = number;


    }
    @Override
    public void update() {

        for (AbstractCard t : AbstractDungeon.player.hand.group) {
            if (t.hasTag(CustomTags.BAIT)) {
                addToTop(new SelectCardsInHandAction(1, "exhaust", false, true, (Predicate<AbstractCard>) card -> card.hasTag(CustomTags.BAIT), abstractCards -> {
                    for (AbstractCard i : abstractCards) {
                        int NEWMAGIC = this.amount * (i.misc / 10);
                        addToBot(new AddTemporaryHPAction(AbstractDungeon.player,AbstractDungeon.player,NEWMAGIC));
                        addToBot(new ExhaustSpecificCardAction(i, AbstractDungeon.player.hand));
                    }}));

            }
        }
        this.isDone=true;
    }
}
