package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class DelphoxVAction extends AbstractGameAction {
    int STRENGTHDOWN;
    @Override
    public void update() {
        STRENGTHDOWN = 0;
        for (AbstractCard c : AbstractDungeon.player.drawPile.group){
            if (c instanceof Burn){
                addToBot(new ExhaustSpecificCardAction(c, AbstractDungeon.player.drawPile, true));
                STRENGTHDOWN +=1;
            }
        }
        for (AbstractCard c : AbstractDungeon.player.hand.group){
            if (c instanceof Burn){
                addToBot(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand, true));
                STRENGTHDOWN +=1;
            }
        }
        for (AbstractCard c : AbstractDungeon.player.discardPile.group){
            if (c instanceof Burn){
                addToBot(new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile, true));
                STRENGTHDOWN +=1;
            }
        }
        if (STRENGTHDOWN >0) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, AbstractDungeon.player, new StrengthPower(monster, -STRENGTHDOWN)));
                }
            }
        }
        this.isDone=true;
    }
}
