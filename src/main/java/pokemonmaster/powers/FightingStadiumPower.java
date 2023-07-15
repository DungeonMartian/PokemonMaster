package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FightingStadiumPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("FightingStadiumPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public FightingStadiumPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card){

        if (type == DamageInfo.DamageType.NORMAL && card.hasTag(CustomTags.POKEMON)&& card.hasTag(CustomTags.FIGHTING))
            return damage + this.amount;
        return damage;
    }

//    public void updateDescription() {
//        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
//    }

    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new FightingStadiumPower(owner, amount);
    }
}