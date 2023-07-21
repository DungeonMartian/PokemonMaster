package pokemonmaster.powers;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.GiantEyeEffect;

import static pokemonmaster.PokemonMasterMod.makeID;

public class OldCemetary extends BasePower {
    public static final String POWER_ID = makeID("OldCemetary");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public OldCemetary(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

    public void updateDescription() {

            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] ;


    }

    @Override
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    if (monster.getIntentBaseDmg() < 0) {
                        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new GiantEyeEffect(monster.hb.cX, monster.hb.cY, Color.PURPLE), 0.1F));

                        addToTop(new DamageAction(monster, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS)));

                    }
                }
            }
        }

        super.atEndOfTurnPreEndTurnCards(isPlayer);
    }






    //Optional, for CloneablePowerInterface.

    public AbstractPower makeCopy() {
        return new OldCemetary(owner, amount);
    }
}