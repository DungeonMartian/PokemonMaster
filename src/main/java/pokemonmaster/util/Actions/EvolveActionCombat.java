package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class EvolveActionCombat extends AbstractGameAction {

    public final AbstractCard toEvolve;
    public final AbstractCard baseCard;

    public CardGroup SORT;

    public AbstractCard c;

    public EvolveActionCombat(AbstractCard c, CardGroup where) {
        this.baseCard= c;
        this.toEvolve = c.cardsToPreview;
        this.SORT = where;

    }

    public void update(){
//are you happy now? the strings are gone, it's better code, but it's lost its charm
        if (this.toEvolve !=null){
            if (SORT== AbstractDungeon.player.discardPile) {
                if (baseCard.upgraded){
                    this.toEvolve.upgrade();
                }
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(this.toEvolve, 1));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.discardPile,true));
            }
            if (SORT == AbstractDungeon.player.hand){
                if (baseCard.upgraded){
                    this.toEvolve.upgrade();
                }
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(this.toEvolve, 1));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.hand,true));
            }
            if (SORT== AbstractDungeon.player.drawPile) {
                if (baseCard.upgraded){
                    this.toEvolve.upgrade();
                }
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(this.toEvolve, 1,true,false));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.drawPile,true));
            }

            }
        if (this.toEvolve ==null){
            if (SORT== AbstractDungeon.player.discardPile) {
                if (baseCard.canUpgrade()) {
                    baseCard.upgrade();
                    baseCard.applyPowers();
                }
                this.isDone = true;
                return;
            }
            if (SORT == AbstractDungeon.player.hand){
                if (baseCard.canUpgrade()) {
                    baseCard.upgrade();
                    baseCard.applyPowers();
                }
                this.isDone = true;
                return;

            }
            if (SORT == AbstractDungeon.player.drawPile){
                if (baseCard.canUpgrade()) {
                    baseCard.upgrade();
                    baseCard.applyPowers();
                }
                this.isDone = true;
                return;

            }

        }
        this.isDone=true;
        }


}


