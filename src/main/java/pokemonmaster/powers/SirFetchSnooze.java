package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EntanglePower;
import com.megacrit.cardcrawl.powers.RegenPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SirFetchSnooze extends BasePower implements CloneablePowerInterface {

    public static final String POWER_ID = makeID("SirFetchSnooze");
    private static final PowerType TYPE = PowerType.DEBUFF;

    private static final boolean TURN_BASED = false;

    public SirFetchSnooze(AbstractCreature owner, int amount) {
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
        AbstractPower pow = AbstractDungeon.player.getPower(RegenPower.POWER_ID);
        if(pow == null) {
        addToBot(new ApplyPowerAction(this.owner, this.owner, new EntanglePower(this.owner)));
}
    }

    @Override
    public int onHeal(int healAmount) {
        AbstractPower pow = AbstractDungeon.player.getPower(EntanglePower.POWER_ID);
        if (pow != null) {
            addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, pow));
            addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        return super.onHeal(healAmount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    @Override
    public AbstractPower makeCopy() {
        return new SirFetchSnooze(owner, amount);
    }
}