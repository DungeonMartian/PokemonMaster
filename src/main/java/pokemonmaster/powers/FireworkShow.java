package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.cards.ChoiceCards.BigOne;
import pokemonmaster.cards.ChoiceCards.Dud;
import pokemonmaster.cards.ChoiceCards.Firework;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FireworkShow extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("FireworkShow");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public FireworkShow(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void atStartOfTurn() {
        int MIN = 1;
        int MAX = 3;
        for (int i = 0; i < this.amount; i++) {
            int RANDOM_INT = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
            if (RANDOM_INT == 1){addToBot(new MakeTempCardInHandAction(new Firework(),1));}
            if (RANDOM_INT == 2){addToBot(new MakeTempCardInHandAction(new Dud(),1));}
            if (RANDOM_INT ==3) {addToBot(new MakeTempCardInHandAction(new BigOne(),1));}
        }


    }

    public void updateDescription() {
        if (this.amount ==1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        }
        else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        }
    }
    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new FireworkShow(owner, amount);
    }
}