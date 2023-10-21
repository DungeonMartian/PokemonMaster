package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import pokemonmaster.cards.StarterRelic.Act3.Beam;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DecaPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("DecaPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public DecaPower(AbstractCreature owner, int amount) {
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


    public void atStartOfTurn() {
        addToBot(new GainBlockAction(owner, this.amount*5));
        addToBot(new ApplyPowerAction(owner, AbstractDungeon.player, new PlatedArmorPower(owner,this.amount)));
        addToBot(new MakeTempCardInHandAction(new Beam(), this.amount));


    }

    @Override
    public AbstractPower makeCopy() {
        return new DecaPower(owner, amount);
    }
}