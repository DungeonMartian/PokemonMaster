package pokemonmaster.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class TimeEating extends BasePower implements NonStackablePower {
    public static final String POWER_ID = makeID("TimeEating");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public TimeEating(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        this.amount=1;
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 998)
            this.amount = 996;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0]  ;
    }


    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        super.onPlayCard(card, m);
        if (this.amount < 12){
            addToBot(new ApplyPowerAction(owner, AbstractDungeon.player, new StrengthPower(owner,2)));
            this.amount+=1;
        }

    }
    public void atEndOfTurn(boolean isPlayer) {
        this.amount = 0;

    }



    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new TimeEating(owner, amount);
    }
}