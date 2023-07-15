package pokemonmaster.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnMyBlockBrokenPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RoughSkin extends BasePower implements OnMyBlockBrokenPower {
    public static final String POWER_ID = makeID("RoughSkin");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    public RoughSkin(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = false;
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
        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }



    public AbstractPower makeCopy() {
        return new RoughSkin(owner, amount);
    }

    @Override
    public void onMyBlockBroken() {
        addToTop(new ApplyPowerAction(this.owner, this.owner, new ThornsPower(this.owner,this.amount)));
        addToTop(new RemoveSpecificPowerAction(owner, owner, this));
    }
}