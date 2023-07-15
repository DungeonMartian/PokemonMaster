package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ArtifactPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CoatingEnergyPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("CoatingEnergyPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public CoatingEnergyPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;
    }



      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void atStartOfTurn() {


        addToBot(new ApplyPowerAction(owner, owner, new ArtifactPower(owner,this.amount)));
    }
    public void atEndOfTurn(boolean isPlayer) {
        AbstractPower pow = AbstractDungeon.player.getPower(ArtifactPower.POWER_ID);
        if (pow != null) {
            addToBot(new ReducePowerAction(this.owner, this.owner, pow, this.amount));
            if (pow.amount <= 0){
                addToBot(new RemoveSpecificPowerAction(this.owner, this.owner,pow));
            }
            }
        }


    @Override
    public AbstractPower makeCopy() {
        return new CoatingEnergyPower(owner, amount);
    }
}