package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ShedinjaPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ShedinjaPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public ShedinjaPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;

    }

      public void updateDescription() {
      this.description = DESCRIPTIONS[0];
    }


    public int onAttackedToChangeDamage(DamageInfo normal, int damageAmount) {
        if (damageAmount > 0)
            return  damageAmount + 9999;
        return damageAmount;

        }


    @Override
    public AbstractPower makeCopy() {
        return new ShedinjaPower(owner, amount);
    }
}