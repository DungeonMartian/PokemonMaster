package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.CustomTags;
import pokemonmaster.powers.Spark;

public class NAction extends AbstractGameAction {
    @Override
    public void update() {
        AbstractDungeon.actionManager.addToTop(new WaitAction(0.4F));
        tickDuration();
        if (this.isDone)
            for (AbstractCard c : DrawCardAction.drawnCards) {
                if (!c.hasTag(CustomTags.DRAGON)) {
                    AbstractDungeon.player.hand.moveToExhaustPile(c);
                    c.triggerOnExhaust();
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new Spark(AbstractDungeon.player,1)));
                }
            }
    }
}
