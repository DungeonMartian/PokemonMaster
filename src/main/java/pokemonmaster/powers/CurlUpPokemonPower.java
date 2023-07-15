package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BlurPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CurlUpPokemonPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("CurlUpPokemonPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public CurlUpPokemonPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (damageAmount < this.owner.currentHealth && damageAmount > 0 && info.owner != null && info.type == DamageInfo.DamageType.NORMAL) {
            this.flash();
            this.addToBot(new GainBlockAction(this.owner, this.owner, this.amount));
            AbstractPower pow = AbstractDungeon.player.getPower(BlurPower.POWER_ID);
            if (pow == null) {
                this.addToTop(new ApplyPowerAction(owner, owner, new BlurPower(owner, 1)));
            }
            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));

        }

        return damageAmount;
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] +this.amount + DESCRIPTIONS[1];
    }
    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new CurlUpPokemonPower(owner, amount);
    }
}