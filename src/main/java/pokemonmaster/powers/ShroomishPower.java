package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ShroomishPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ShroomishPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public ShroomishPower(AbstractCreature owner, int amount) {
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
    public int onAttackedToChangeDamage(DamageInfo normal, int damageAmount) {
    if (damageAmount > 0) {
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }
        return damageAmount;
    }
    public void onEnergyRecharge() {
        AbstractMonster abstractMonster = AbstractDungeon.getRandomMonster();
        if (abstractMonster != null) {
            addToBot(new DamageRandomEnemyAction(new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }
    }
    @Override
    public AbstractPower makeCopy() {
        return new ShroomishPower(owner, amount);
    }
}