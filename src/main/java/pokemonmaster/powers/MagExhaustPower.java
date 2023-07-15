package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MagExhaustPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("MagExhaustPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public MagExhaustPower(AbstractCreature owner, int amount) {
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
        if (this.amount ==1) {
            this.description = DESCRIPTIONS[0] ;
        }
        else {
            this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2] ;
        }
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.STATUS){
            action.exhaustCard = true;
            AbstractDungeon.player.getPower(MagExhaustPower.POWER_ID).amount-=1;
            if(AbstractDungeon.player.getPower(MagExhaustPower.POWER_ID).amount == 0) {
                addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, AbstractDungeon.player.getPower(MagExhaustPower.POWER_ID)));
            }
    }
    }
 //   public void onEnergyRecharge() {
 //       addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, AbstractDungeon.player.getPower(MagExhaustPower.POWER_ID)));
 //   }


    @Override
    public AbstractPower makeCopy() {
        return new MagExhaustPower(owner, amount);
    }
}