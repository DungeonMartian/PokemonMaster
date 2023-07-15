package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ToxicSpikes extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ToxicSpikes");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public ToxicSpikes(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = false;
        this.priority = 99;

    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != this.owner) {
            flash();
            addToBot(new ApplyPowerAction(info.owner, AbstractDungeon.player, new PoisonPower(info.owner,  owner,this.amount), this.amount));

        }

        return damageAmount;
    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
    public void atStartOfTurn() {
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));

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
        return new ToxicSpikes(owner, amount);
    }
}