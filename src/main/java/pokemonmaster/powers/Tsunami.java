package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.cards.ChoiceCards.Surf;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tsunami extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Tsunami");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public Tsunami(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;


    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 998;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]+this.amount + DESCRIPTIONS[2];
    }


    public void atStartOfTurn() {
        addToTop(new MakeTempCardInHandAction(new Surf(),this.amount));
        addToBot(new RemoveSpecificPowerAction(owner,owner,this));
    }
    @Override
    public AbstractPower makeCopy() {
        return new Tsunami(owner, amount);
    }
}