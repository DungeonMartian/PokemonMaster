package pokemonmaster.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.GiantEyeEffect;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cursed extends BasePower implements HealthBarRenderPower {
    public static final String POWER_ID = makeID("Cursed");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.
    public boolean DAMAGED;
    public Cursed(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        DAMAGED = false;

    }




    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if (!this.owner.isPlayer){

        }
        if (damageAmount > 0){
            DAMAGED = false;

        }
        super.onAttack(info, damageAmount, target);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {

        addToBot(new LoseHPAction(this.owner, this.owner, this.amount));
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new GiantEyeEffect(this.owner.hb.cX, this.owner.hb.cY, Color.PURPLE), 0.1F));
        DAMAGED = false;

        //if (this.owner.getIntentBaseDmg() < 0){
        //    addToBot(new LoseHPAction(this.owner, this.owner, this.amount));
        //    AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new GiantEyeEffect(target.hb.cX, target.hb.cY, Color.PURPLE), 0.1F));

        //}

        super.atEndOfTurn(isPlayer);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new Cursed(owner, amount);
    }

    @Override
    public int getHealthBarAmount() {
        return this.amount;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }
}