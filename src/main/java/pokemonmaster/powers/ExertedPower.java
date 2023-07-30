package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ExertedPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ExertedPower");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;

    public ExertedPower(AbstractCreature owner, int amount) {
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
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }


    public void atStartOfTurn() {

        addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner,-this.amount)));
        addToBot(new ApplyPowerAction(owner, owner, new GainStrengthPower(owner,this.amount)));
        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }
    @Override
    public AbstractPower makeCopy() {
        return new ExertedPower(owner, amount);
    }
}