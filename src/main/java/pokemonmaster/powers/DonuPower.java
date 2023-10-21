package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.StarterRelic.Act3.Beam;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DonuPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("DonuPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public DonuPower(AbstractCreature owner, int amount) {
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
        addToBot(new ApplyPowerAction(owner, AbstractDungeon.player, new StrengthPower(owner,this.amount)));
        addToBot(new ApplyPowerAction(owner, AbstractDungeon.player, new ArtifactPower(owner,this.amount/3)));
        addToBot(new MakeTempCardInHandAction(new Beam(), this.amount/3));


    }

    @Override
    public AbstractPower makeCopy() {
        return new DonuPower(owner, amount);
    }
}