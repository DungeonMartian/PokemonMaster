package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ZamazentaPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ZamazentaPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public ZamazentaPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = false;
        this.priority = 99;

    }


    public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        addToBot(new ApplyPowerAction(owner, owner, new Resistant(owner, EnergyPanel.totalCount*this.amount)));

    }



    @Override
    public AbstractPower makeCopy() {
        return new ZamazentaPower(owner, amount);
    }
}