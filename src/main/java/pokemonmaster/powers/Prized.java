package pokemonmaster.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Prized extends BasePower implements HealthBarRenderPower {
    public static final String POWER_ID = makeID("Prized");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = true;

    public Prized(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased =false;
        this.priority = 99;

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    //public void onEnergyRecharge() {
    //    addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    //}

    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        if (damageAmount > 0 && info.type == DamageInfo.DamageType.NORMAL) {
            addToTop(new ReducePowerAction(owner, owner, this, 1));
            return damageAmount +6;
        }
        return damageAmount;
    }




    public AbstractPower makeCopy() {
        return new Prized(owner, amount);
    }

    @Override
    public int getHealthBarAmount() {
        return 6;
    }

    @Override
    public Color getColor() {
        return Color.SLATE;
    }
}