package pokemonmaster.powers;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MysteryCharge extends BasePower {
    public static final String POWER_ID = makeID("MysteryCharge");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.
    private boolean TODO = true;
    public MysteryCharge(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0]+this.amount +DESCRIPTIONS[1]+this.amount + DESCRIPTIONS[2]  ;
    }


    @Override
    public void atStartOfTurnPostDraw() {
        if (AbstractDungeon.player.discardPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.discardPile.group) {
                if (i.hasTag(CustomTags.SUPPORTER)) {
                    TODO=false;
                }

            }
        }
        if (AbstractDungeon.player.drawPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.drawPile.group) {
                if (i.hasTag(CustomTags.SUPPORTER)) {
                    TODO=false;
                }

            }
        }
        if (TODO){
            addToBot(new GainEnergyAction(this.amount));
            addToBot(new DrawCardAction(this.amount));
        }
        this.TODO = true;
        super.atStartOfTurnPostDraw();


    }

//Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new MysteryCharge(owner, amount);
    }
}