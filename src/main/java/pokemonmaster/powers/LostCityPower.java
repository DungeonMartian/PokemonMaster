package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LostCityPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("LostCityPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public LostCityPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 999;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }



    public void onCardDraw(AbstractCard card) {
        card.setCostForTurn(card.cost -this.amount);
    }
    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
            flash();

            action.exhaustCard = true;

    }
    public void onInitialApplication() {

    }
    @Override
    public AbstractPower makeCopy() {
        return new LostCityPower(owner, amount);
    }
}