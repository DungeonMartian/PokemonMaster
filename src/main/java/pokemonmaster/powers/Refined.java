package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.cards.Psychic.Ralts;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Refined extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Refined");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public Refined(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;


    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 998;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]+this.amount + DESCRIPTIONS[2];
    }


    public void atStartOfTurn() {
        addToBot(new DrawCardAction(owner, this.amount));
        addToBot(new MakeTempCardInHandAction(new Ralts(),this.amount));
    }
    @Override
    public AbstractPower makeCopy() {
        return new Refined(owner, amount);
    }
}