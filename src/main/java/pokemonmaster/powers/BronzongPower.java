package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BronzongPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("BronzongPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private int STACKS = 0;
    public BronzongPower(AbstractCreature owner, int amount) {
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
        if (this.amount ==1) {
            this.description = DESCRIPTIONS[0] ;
        }
        else {
            this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2] ;
        }
    }

    @Override
    public void onEnergyRecharge() {
        STACKS = this.amount;
        addToBot(new ApplyPowerAction(this.owner, this.owner, new MagExhaustPower(this.owner,STACKS)));
    }


    @Override
    public AbstractPower makeCopy() {
        return new BronzongPower(owner, amount);
    }


}