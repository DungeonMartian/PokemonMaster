package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.powers.HeldItemPlayed;

public class ZigzagoonAction extends AbstractGameAction {

    private boolean UPGRADED;

    public ZigzagoonAction(AbstractCreature target, boolean isUpgraded) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = AbstractGameAction.ActionType.WAIT;
        this.source = AbstractDungeon.player;
        this.target = target;
        UPGRADED = isUpgraded;
    }
    @Override
    public void update() {
        AbstractPower pow = AbstractDungeon.player.getPower(HeldItemPlayed.POWER_ID);
        if (pow != null) {
            addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, pow));
        }
        AbstractCard card = AbstractDungeon.getCardFromPool(AbstractCard.CardRarity.RARE, AbstractCard.CardType.SKILL,true);
        while (!card.hasTag(CustomTags.HELDITEM) )
            card = AbstractDungeon.getCardFromPool(AbstractCard.CardRarity.RARE, AbstractCard.CardType.SKILL,true);
        if (UPGRADED){
            card.upgrade();
        }
        card.purgeOnUse=true;
        addToTop(new NewQueueCardAction(card, this.target, false, true));

        this.isDone = true;
    }

}
