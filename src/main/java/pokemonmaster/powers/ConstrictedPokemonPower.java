package pokemonmaster.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ConstrictedPokemonPower extends BasePower implements HealthBarRenderPower {
    public static final String POWER_ID = makeID("ConstrictedPokemonPower");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.


    public ConstrictedPokemonPower(AbstractCreature target, AbstractCreature source, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, target, source, amount);
        this.owner = target;
        this.source = source;
        this.amount = amount;
        updateDescription();
        loadRegion("constricted");
        this.type = AbstractPower.PowerType.DEBUFF;
        this.priority = 105;
    }
    public void atStartOfTurn() {
        flashWithoutSound();
        playApplyPowerSfx();
        addToBot(new DamageAction(this.owner, new DamageInfo(this.source, this.amount, DamageInfo.DamageType.THORNS)));

    }
    public void playApplyPowerSfx() {
        CardCrawlGame.sound.play("POWER_CONSTRICTED", 0.05F);
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new ConstrictedPokemonPower(owner, source, amount);
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