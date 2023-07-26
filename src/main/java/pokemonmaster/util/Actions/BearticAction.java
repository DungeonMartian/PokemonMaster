package pokemonmaster.util.Actions;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;

import java.util.function.Predicate;


public class BearticAction extends AbstractGameAction {
    public BearticAction (Integer number){
    this.amount = number;


    }
    @Override
    public void update() {

        for (AbstractCard t : AbstractDungeon.player.hand.group) {
            if (t.hasTag(CustomTags.BAIT)) {
                addToTop(new SelectCardsInHandAction(1, "exhaust", false, true, (Predicate<AbstractCard>) card -> card.hasTag(CustomTags.BAIT), abstractCards -> {
                    for (AbstractCard i : abstractCards) {
                        int NEWMAGIC = this.amount * (i.misc / 10);

                        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, NEWMAGIC)));
                        addToBot(new ExhaustSpecificCardAction(i, AbstractDungeon.player.hand));
                    }}));

            }
        }
        this.isDone=true;
    }
}