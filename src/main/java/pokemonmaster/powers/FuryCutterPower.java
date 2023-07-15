package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FuryCutterPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("FuryCutterPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public FuryCutterPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = false;
        this.priority = 99;

    }


    public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        addToBot(new ReducePowerAction(this.owner, this.owner, this, this.amount));
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card) {
        if (card.hasTag(AbstractCard.CardTags.STRIKE)) {
            return damage +this.amount;
        }
        return damage;
    }

    @Override
    public AbstractPower makeCopy() {
        return new FuryCutterPower(owner, amount);
    }
}