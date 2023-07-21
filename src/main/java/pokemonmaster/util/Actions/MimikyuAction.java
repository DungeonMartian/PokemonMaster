package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Iterator;

public class MimikyuAction extends AbstractGameAction {

    private AbstractPlayer player;
    private int playAmt;

    public MimikyuAction() {
        this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
        this.player = AbstractDungeon.player;
    }

    @Override
    public void update() {
        if (this.duration == this.startDuration) {
            if (this.player.exhaustPile.isEmpty()) {
                this.isDone = true;
            } else {
                CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                Iterator var6 = this.player.exhaustPile.group.iterator();

                while(var6.hasNext()) {
                    AbstractCard c = (AbstractCard)var6.next();
                    temp.addToTop(c);
                }

                temp.sortAlphabetically(true);
                temp.sortByRarityPlusStatusCardType(false);
                AbstractDungeon.gridSelectScreen.open(temp, 1, "Exhaust", false);
                this.tickDuration();
            }
        } else {
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                Iterator var1 = AbstractDungeon.gridSelectScreen.selectedCards.iterator();

                while(var1.hasNext()) {
                    AbstractCard c = (AbstractCard)var1.next();
                    this.addToBot(new NewQueueCardAction(c, true, false, true));

                    for(int i = 0; i < this.playAmt - 1; ++i) {
                        AbstractCard tmp = c.makeStatEquivalentCopy();
                        tmp.purgeOnUse = true;
                        addToTop(new NewQueueCardAction(tmp, this.target, false, true));
                        this.addToBot(new NewQueueCardAction(tmp, true, false, true));
                    }
                }

                AbstractDungeon.gridSelectScreen.selectedCards.clear();
                AbstractDungeon.player.hand.refreshHandLayout();
            }

            this.tickDuration();
        }
    }
}
