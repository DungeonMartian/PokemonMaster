package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.evacipated.cardcrawl.mod.stslib.actions.common.MoveCardsAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;

import java.util.function.Predicate;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SlowStart extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("SlowStart");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public SlowStart(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    private boolean REGIROCK = false;
    private boolean REGISTEEL = false;
    private boolean REGIELEC = false;
    private boolean REGIDRAGO = false;
    private boolean REGICE = false;

    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        if (card.hasTag(CustomTags.REGICE)){
        REGICE=true;

        }
        if (card.hasTag(CustomTags.REGIROCK)){
        REGIROCK=true;
        }
        if (card.hasTag(CustomTags.REGIDRAGO)){
        REGIDRAGO=true;
        }
        if (card.hasTag(CustomTags.REGIELEC)){
        REGIELEC=true;
        }
        if (card.hasTag(CustomTags.REGISTEEL)){
        REGISTEEL=true;
        }
        if (REGICE && REGIROCK && REGIDRAGO && REGIELEC && REGISTEEL){
            addToBot(new MoveCardsAction(AbstractDungeon.player.hand, AbstractDungeon.player.exhaustPile, (Predicate<AbstractCard>) ((c) -> c.hasTag(CustomTags.REGIGIGAS))));
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));

        }

        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
        if (!REGICE){
            this.description += DESCRIPTIONS[2];
        }
        if (!REGIROCK){
            this.description += DESCRIPTIONS[3];
        }
        if (!REGIDRAGO){
            this.description += DESCRIPTIONS[4];
        }
        if (!REGIELEC){
            this.description += DESCRIPTIONS[5];
        }
        if (!REGISTEEL){
            this.description += DESCRIPTIONS[6];
        }
        this.description += DESCRIPTIONS[7];
        updateDescription();
        super.onPlayCard(card, m);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 1)
            this.amount = 1;
    }
    public void updateDescription() {

        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
        if (!REGICE){
            this.description += DESCRIPTIONS[2];
        }
        if (!REGIROCK){
            this.description += DESCRIPTIONS[3];
        }
        if (!REGIDRAGO){
            this.description += DESCRIPTIONS[4];
        }
        if (!REGIELEC){
            this.description += DESCRIPTIONS[5];
        }
        if (!REGISTEEL){
            this.description += DESCRIPTIONS[6];
        }
        this.description += DESCRIPTIONS[7];
    }
    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new SlowStart(owner, amount);
    }
}