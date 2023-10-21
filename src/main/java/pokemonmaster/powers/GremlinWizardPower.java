package pokemonmaster.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GremlinWizardPower extends BasePower implements NonStackablePower {
    public static final String POWER_ID = makeID("GremlinWizardPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    private int damage;
    public boolean DISABLE;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public GremlinWizardPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.priority = 99;
        if (this.amount >= 999)
            this.amount = 999;
        this.damage = 20;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] ;
    }



    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            addToBot(new ReducePowerAction(this.owner, this.owner, this, 1));
            if (this.amount == 1)

                addToBot(new DamageRandomEnemyAction(new DamageInfo(this.owner, 20, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));

        }


    }



    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new GremlinWizardPower(owner, amount);
    }
}