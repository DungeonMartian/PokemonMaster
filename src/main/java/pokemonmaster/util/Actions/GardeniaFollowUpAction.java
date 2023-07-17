package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GardeniaFollowUpAction extends AbstractGameAction {
    @Override
    public void update() {
        AbstractDungeon.actionManager.addToTop(new WaitAction(0.4F));
        tickDuration();
        if (this.isDone)
            for (AbstractCard c : DrawCardAction.drawnCards) {
                if (c.type == AbstractCard.CardType.POWER) {
                    c.costForTurn=c.cost-1;
                    c.isCostModifiedForTurn=true;

                }
            }
    }
}
