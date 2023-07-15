package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ChesnaughtVPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ChesnaughtVPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    public ChesnaughtVPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 999;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public void onEnergyRecharge() {
        addToBot(new ApplyPowerAction(this.owner, this.owner, new ThornsPower(this.owner,this.amount)));
    }


    @Override
    public AbstractPower makeCopy() {
        return new ChesnaughtVPower(owner, amount);
    }
}