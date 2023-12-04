package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.util.Actions.BetterSelectCardsAction;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Smelt extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Smelt");
    private static final PowerType TYPE = PowerType.BUFF;
    private AbstractCard HELP;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public Smelt(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.priority = 99;
        if (this.amount >= 999)
            this.amount = 999;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] ;
    }



    public void atStartOfTurn() {
    //for (int i=0; i < this.amount; i++) {
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
            addToBot(new BetterSelectCardsAction(AbstractDungeon.player.discardPile.group, this.amount, "Choose card to exhaust", (cards) -> {
                for (AbstractCard c : cards) {
                    //HELP = c;
                    addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile));
                    //AbstractDungeon.player.discardPile.moveToExhaustPile(c);
                    addToBot(new GainEnergyAction(1));
                }
                addToTop(new ExhaustSpecificCardAction(HELP, AbstractDungeon.player.discardPile));
            }));
        }
   //     if (AbstractDungeon.player.discardPile.isEmpty()) {
   //         break;
   //     }
   // }
    }



    //Optional, for CloneablePowerInterface.
@Override
    public AbstractPower makeCopy() {
        return new Smelt(owner, amount);
    }
}