package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class EvolveActionCombat extends AbstractGameAction {

    public final AbstractCard toEvolve;
    public final AbstractCard baseCard;
    public String SORT;
    public AbstractCard c;

    public EvolveActionCombat(AbstractCard c, String where) {
        this.baseCard= c;
        this.toEvolve = c.cardsToPreview;
        this.SORT = where;
    }

    public void update(){
//waahhh waahhh hard coded strings fight me I got it working
        if (this.toEvolve !=null){
            if (SORT== "discard") {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction( this.toEvolve, 1));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.discardPile,true));
            }
            if (SORT == "hand"){
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(this.toEvolve, 1));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.hand,true));
            }
            if (SORT== "draw") {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(this.toEvolve, 1,true,false));
                addToTop(new ExhaustSpecificCardAction(baseCard,AbstractDungeon.player.drawPile,true));
            }

            }
        if (this.toEvolve ==null){
            if (SORT== "discard") {
                if (baseCard.canUpgrade()) {
                    baseCard.upgrade();
                    baseCard.applyPowers();
                }
                this.isDone = true;
                return;
            }
            if (SORT == "hand"){
                if (baseCard.canUpgrade()) {
                    baseCard.upgrade();
                    baseCard.applyPowers();
                }
                this.isDone = true;
                return;

            }
            if (SORT == "draw"){
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


