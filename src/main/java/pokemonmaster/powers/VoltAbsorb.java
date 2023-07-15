package pokemonmaster.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class VoltAbsorb extends BasePower implements NonStackablePower {
    public static final String POWER_ID = makeID("VoltAbsorb");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public VoltAbsorb(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public Boolean TODO = true;


    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            this.amount += card.damage;
        }
        if (this.amount >= 40 && TODO ){
            addToBot(new ApplyPowerAction(owner, owner, new IntangiblePlayerPower(owner,1)));
            TODO =false;
        }

    }
    public void atStartOfTurn() {
        TODO = true;
        this.amount =0;
    }



    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new VoltAbsorb(owner, amount);
    }
}