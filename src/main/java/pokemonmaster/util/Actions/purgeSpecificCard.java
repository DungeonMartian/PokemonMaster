package pokemonmaster.util.Actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ExhaustCardEffect;

public class purgeSpecificCard extends AbstractGameAction {
    private AbstractCard targetCard;
    private CardGroup group;
    private float startingDuration;

    public purgeSpecificCard(AbstractCard targetCard, CardGroup group, boolean isFast) {
        this.targetCard = targetCard;
        this.setValues(AbstractDungeon.player, AbstractDungeon.player, this.amount);
        this.actionType = ActionType.EXHAUST;
        this.group = group;
        this.startingDuration = Settings.ACTION_DUR_FAST;
        this.duration = this.startingDuration;
    }

    public purgeSpecificCard(AbstractCard targetCard, CardGroup group) {
        this(targetCard, group, false);
    }

    public void update() {
        if (this.duration == this.startingDuration && this.group.contains(this.targetCard)) {
            this.group.removeCard(this.targetCard);
            resetCardBeforeMoving(this.targetCard);
            AbstractDungeon.effectList.add(new ExhaustCardEffect(this.targetCard));
            this.targetCard.exhaustOnUseOnce = false;
            this.targetCard.freeToPlayOnce = false;
        }

        this.tickDuration();
    }
    private void resetCardBeforeMoving(AbstractCard c) {
        if (AbstractDungeon.player.hoveredCard == c)
            AbstractDungeon.player.releaseCard();
        AbstractDungeon.actionManager.removeFromQueue(c);
        c.unhover();
        c.untip();
        c.stopGlowing();

    }
}