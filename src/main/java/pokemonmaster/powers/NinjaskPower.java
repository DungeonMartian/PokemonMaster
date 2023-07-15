package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class NinjaskPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("NinjaskPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
public int count = 0;
    public NinjaskPower(AbstractCreature owner, int amount) {
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

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK){
            count ++;
        }
        if (count ==2 ) {
            addToBot(new ApplyPowerAction(owner, owner, new DexterityPower(owner,this.amount)));
        }


    }
    public void onEnergyRecharge() {
        count = 0;
    }


    @Override
    public AbstractPower makeCopy() {
        return new NinjaskPower(owner, amount);
    }
}