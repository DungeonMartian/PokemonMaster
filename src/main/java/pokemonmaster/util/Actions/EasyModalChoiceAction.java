package pokemonmaster.util.Actions;


import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsCenteredAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class EasyModalChoiceAction extends SelectCardsCenteredAction {
    public EasyModalChoiceAction(ArrayList<AbstractCard> list, int amount, String textforSelect) {
        super(list, amount, textforSelect, cards -> {
            for (AbstractCard q : cards) {
                q.onChoseThisOption();
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(q, true));
            }
        });
    }


}
