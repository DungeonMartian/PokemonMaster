package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class NextAttackModified extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("NextAttackModified");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.


    public NextAttackModified(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card){

        if (type == DamageInfo.DamageType.NORMAL) {
            return damage - this.amount;

        }
        return damage;

    }
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            flash();
            addToBot(new ReducePowerAction(this.owner, this.owner, this, this.amount));
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }
    }
    public void atStartOfTurn() {
        addToBot(new ReducePowerAction(this.owner, this.owner, this, this.amount));
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new NextAttackModified(owner, amount);
    }
}