package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class StunfiskBite extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("StunfiskBite");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public StunfiskBite(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = false;
        this.priority = 99;

    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != this.owner) {
            flash();
            addToTop(new DamageAction(info.owner, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
            addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }

        return damageAmount;
    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }



//        public float atDamageReceive(float damage, DamageInfo.DamageType type) {
//            if (type == DamageInfo.DamageType.NORMAL) {
//                if (this.owner.isPlayer && AbstractDungeon.player.hasRelic("Odd Mushroom"))
//                    return damage * 1.25F;
//                if (this.owner != null && !this.owner.isPlayer && AbstractDungeon.player.hasRelic("Paper Frog"))
//                    return damage * 1.75F;
//                return damage * 1.5F;
//            }
//            return damage;

    @Override
    public AbstractPower makeCopy() {
        return new StunfiskBite(owner, amount);
    }
}