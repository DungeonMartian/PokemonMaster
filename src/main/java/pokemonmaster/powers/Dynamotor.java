package pokemonmaster.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Dynamotor extends BasePower {
    public static final String POWER_ID = makeID("Dynamotor");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public Dynamotor(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

    public void updateDescription() {
        if (this.amount ==1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]+this.amount +DESCRIPTIONS[3] ;
        }
        else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2]+this.amount +DESCRIPTIONS[3];
        }
    }

    @Override
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
            if (AbstractDungeon.player.discardPile.size() < this.amount) {
                for (int i = 1; i <= AbstractDungeon.player.discardPile.size(); ) {
                    AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                    AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                }
            }
            else for (int i = 1;  i <= this.amount; i++) {
                AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                AbstractDungeon.player.discardPile.moveToExhaustPile(card);
            }

        }
        addToBot(new ApplyPowerAction(owner, owner, new Spark(owner, this.amount)));

        super.atEndOfTurnPreEndTurnCards(isPlayer);
    }






    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new Dynamotor(owner, amount);
    }
}