package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

public class CryogonalScryAction extends AbstractGameAction {


        private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ReprogramAction");

        public static final String[] TEXT = uiStrings.TEXT;

        private final float startingDuration;

        public CryogonalScryAction(int numCards) {
            this.amount = numCards;
            if (AbstractDungeon.player.hasRelic("GoldenEye")) {
                AbstractDungeon.player.getRelic("GoldenEye").flash();
                this.amount += 2;
            }
            this.actionType = ActionType.CARD_MANIPULATION;
            this.startingDuration = Settings.ACTION_DUR_FAST;
            this.duration = this.startingDuration;
        }

        public void update() {
            if (AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
                this.isDone = true;
                return;
            }
            if (this.duration == this.startingDuration) {
                for (AbstractPower p : AbstractDungeon.player.powers)
                    p.onScry();
                if (AbstractDungeon.player.drawPile.isEmpty()) {
                    this.isDone = true;
                    return;
                }
                CardGroup tmpGroup = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                if (this.amount != -1) {
                    for (int i = 0; i < Math.min(this.amount, AbstractDungeon.player.drawPile.size()); i++)
                        tmpGroup.addToTop(AbstractDungeon.player.drawPile.group
                                .get(AbstractDungeon.player.drawPile.size() - i - 1));
                } else {
                    for (AbstractCard c : AbstractDungeon.player.drawPile.group)
                        tmpGroup.addToBottom(c);
                }
                AbstractDungeon.gridSelectScreen.open(tmpGroup, this.amount, true, "Choose any number of cards to Exhaust");
            } else if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                        AbstractDungeon.player.drawPile.moveToExhaustPile(c);
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EnergizedPower(AbstractDungeon.player, 1)));
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DrawCardNextTurnPower(AbstractDungeon.player, 1)));
                }
                AbstractDungeon.gridSelectScreen.selectedCards.clear();
            }
            for (AbstractCard c : AbstractDungeon.player.discardPile.group)
                c.triggerOnScry();
            tickDuration();
        }
    }

