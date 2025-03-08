package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import pokemonmaster.cards.StarterRelic.Pokeball;

public class SmeargleAction extends AbstractGameAction {

    private final AbstractCreature TARGET;

    public SmeargleAction(AbstractCreature target){
        this.TARGET = target;
        this.duration = 0.1F;
    }

    @Override
    public void update() {
        if (this.duration == 0.1F &&
                this.TARGET != null) {

            if (!this.TARGET.hasPower("Minion")) {
                addToTop(new MakeTempCardInHandAction(Pokeball.AddThis(TARGET.id)));

            }

        }
        tickDuration();
    }

}
