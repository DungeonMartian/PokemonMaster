package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Barrier extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Barrier");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;
    private boolean TOREDUCE= false;

    public Barrier(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;
    }

      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL) {
            TOREDUCE = true;
            return damage - this.amount;
        }
        return damage;
    }
    public void atStartOfTurn() {
        if (TOREDUCE) {
            addToBot(new ReducePowerAction(owner, owner, this, 1));
        }
        TOREDUCE = false;
    }

    @Override
    public AbstractPower makeCopy() {
        return new Barrier(owner, amount);
    }
}