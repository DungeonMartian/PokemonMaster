package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.cards.StarterRelic.Act1.*;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GremlinLeaderPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("GremlinLeaderPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public GremlinLeaderPower(AbstractCreature owner, int amount) {
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
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }


    public void atStartOfTurn() {
    for (int i =1; i <= this.amount; i++) {

        int MIN = 1;
        int MAX = 5;
        int RANDOM_INT = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        if (RANDOM_INT == 1){addToBot(new MakeTempCardInHandAction(new GremlinFat(),1));}
        if (RANDOM_INT == 2){addToBot(new MakeTempCardInHandAction(new GremlinMad(),1));}
        if (RANDOM_INT ==3) {addToBot(new MakeTempCardInHandAction(new GremlinShield(),1));}
        if (RANDOM_INT ==4) {addToBot(new MakeTempCardInHandAction(new GremlinSneaky(),1));}
        if (RANDOM_INT ==5) {addToBot(new MakeTempCardInHandAction(new GremlinWizard(),1));}

        }
    }
    @Override
    public AbstractPower makeCopy() {
        return new GremlinLeaderPower(owner, amount);
    }
}