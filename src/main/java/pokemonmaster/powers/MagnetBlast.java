package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import static pokemonmaster.PokemonMasterMod.makeID;

public class MagnetBlast extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("MagnetBlast");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public MagnetBlast(AbstractCreature owner, int amount) {
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

    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        super.onPlayCard(card, m);
        if (card.type == AbstractCard.CardType.STATUS){
        addToTop(new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(this.amount, true), DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }
    }

    @Override
    public AbstractPower makeCopy() {
        return new MagnetBlast(owner, amount);
    }
}