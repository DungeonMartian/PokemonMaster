package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EntanglePower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EntangleNext extends BasePower implements CloneablePowerInterface {

    public static final String POWER_ID = makeID("EntangleNext");
    private static final PowerType TYPE = PowerType.DEBUFF;

    private static final boolean TURN_BASED = false;

    public EntangleNext(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;

    }
    public void stackPower(int stackAmount) {
      super.stackPower(stackAmount);
      if (this.amount > 1)
          this.amount = 1;
    }

    public void atEndOfTurn(boolean isPlayer) {

            addToBot(new ApplyPowerAction(this.owner, this.owner, new EntanglePower(this.owner)));

        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    @Override
    public AbstractPower makeCopy() {
        return new EntangleNext(owner, amount);
    }
}