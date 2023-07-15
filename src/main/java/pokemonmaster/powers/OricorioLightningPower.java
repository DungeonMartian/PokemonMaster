package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class OricorioLightningPower extends BasePower implements CloneablePowerInterface {

    public static final String POWER_ID = makeID("OricorioLightningPower");
    private static final PowerType TYPE = PowerType.BUFF;

    private static final boolean TURN_BASED = false;

    public OricorioLightningPower(AbstractCreature owner, int amount) {
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

    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            addToBot(new ReducePowerAction(owner, owner, this, 1));
        }
    }

    //public float atDamageGive(float damage, DamageInfo.DamageType type) {
    //    return type == DamageInfo.DamageType.NORMAL ? damage + 0 : (damage*1.5F);
    //}
    public float atDamageGive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL)
            return damage * 1.5F;
        return damage;
    }
    public void updateDescription() {
        if (this.amount ==1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        }
        else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new OricorioLightningPower(owner, amount);
    }
}