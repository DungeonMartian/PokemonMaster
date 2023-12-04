package pokemonmaster.powers;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.RedFireballEffect;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MagmaBasinPower extends BasePower {
    public static final String POWER_ID = makeID("MagmaBasinPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public MagmaBasinPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] ;
    }
    //Optional, for CloneablePowerInterface.


    public void atStartOfTurn() {
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new RedFireballEffect(this.owner.hb.cX-5,this.owner.hb.cY,this.owner.hb.cX+5,this.owner.hb.cY, 3), 0.1F));

        addToTop(new LoseHPAction(owner,owner,2*this.amount));
        addToTop(new ApplyPowerAction(this.owner, this.owner, new Spark(this.owner, this.amount), this.amount));
    }
    public AbstractPower makeCopy() {
        return new MagmaBasinPower(owner, amount);
    }


}