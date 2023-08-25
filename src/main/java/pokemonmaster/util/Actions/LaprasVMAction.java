package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;

public class LaprasVMAction extends AbstractGameAction {

    public int[] multiDamage;

    private boolean freeToPlayOnce = false;

    private final DamageInfo.DamageType damageType;


    private final AbstractPlayer p;

    private int ENERGY = -1;

    public LaprasVMAction(AbstractPlayer p, int[] multiDamage, DamageInfo.DamageType damageType, boolean freeToPlayOnce, int energyOnUse) {
        this.multiDamage = multiDamage;
        this.damageType = damageType;
        this.p = p;
        this.freeToPlayOnce = freeToPlayOnce;
        this.duration = Settings.ACTION_DUR_XFAST;
        this.actionType = AbstractGameAction.ActionType.SPECIAL;
        this.ENERGY = energyOnUse;
    }

    @Override
    public void update() {
        for (int i = 1; i <= this.ENERGY; i++) {

            addToBot(new DamageAllEnemiesAction(this.p, this.multiDamage, this.damageType, AttackEffect.NONE, true));
        }
        this.isDone = true;
    }
}
