package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class XatuScryAction extends AbstractGameAction {


        private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ReprogramAction");

        public static final String[] TEXT = uiStrings.TEXT;

        private float startingDuration;

        public XatuScryAction(int numCards) {
            this.amount = numCards;
            if (AbstractDungeon.player.hasRelic("GoldenEye")) {
                AbstractDungeon.player.getRelic("GoldenEye").flash();
                this.amount += 2;
            }
            this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
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
                AbstractDungeon.gridSelectScreen.open(tmpGroup, this.amount, true, TEXT[0]);
            } else if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                    if (c.type == AbstractCard.CardType.STATUS) {
                        AbstractDungeon.player.drawPile.moveToExhaustPile(c);
                    }
                    else {
                        AbstractDungeon.player.drawPile.moveToDiscardPile(c);

                    }
                }
                AbstractDungeon.gridSelectScreen.selectedCards.clear();
            }
            for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
                c.triggerOnScry();

            }
            tickDuration();
        }
    }

