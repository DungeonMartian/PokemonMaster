package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import pokemonmaster.powers.HeldItemPlayed;

public class HeldItemAction extends AbstractGameAction{

    AbstractGameAction action;
    @Override
    public void update() {
        AbstractPower pow = AbstractDungeon.player.getPower(HeldItemPlayed.POWER_ID);
        // check if player has power that indicates a held item was played
        if (pow == null || pow.amount == 0) {
            addToTop(action);
        }
        this.isDone = true;
    }
    
    public HeldItemAction(AbstractGameAction action) {
        this.action = action;
    }
}
