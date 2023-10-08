package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.RedFireballEffect;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Spark extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Spark");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public Spark(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;
        this.canGoNegative = true;

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 999;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
          if (this.amount >= 4){
              this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
          }
    }

    public void onEnergyRecharge() {
        AbstractDungeon.player.gainEnergy(this.amount);

        if (this.amount >= 4){
            addToTop(new LoseHPAction(owner,owner,this.amount/4));
            AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new RedFireballEffect(owner.hb.cX-5* Settings.scale,owner.hb.cY,owner.hb.cX+5* Settings.scale,owner.hb.cY, 0), 0.1F));
        }
    }




    @Override
    public AbstractPower makeCopy() {
        return new Spark(owner, amount);
    }
}