package pokemonmaster.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Burned extends BasePower implements HealthBarRenderPower {
    public static final String POWER_ID = makeID("Burned");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public Burned(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void atStartOfTurn() {
        addToBot(new LoseHPAction(this.owner, this.owner, this.amount, AbstractGameAction.AttackEffect.FIRE));

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new Burned(owner, amount);
    }

    @Override
    public int getHealthBarAmount() {
        return this.amount;
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}