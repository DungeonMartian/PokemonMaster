package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;

public class TropiusAction extends AbstractGameAction {

    public TropiusAction(AbstractCreature target, int numPotions) {
        this.amount = numPotions;
        this.actionType = ActionType.BLOCK;
        this.target = target;
    }

    @Override
    public void update() {
        for (int i = 0; i < this.amount; i++) {
            AbstractPotion po = AbstractDungeon.returnRandomPotion(true);
            while (po instanceof com.megacrit.cardcrawl.potions.SmokeBomb || po instanceof com.megacrit.cardcrawl.potions.FairyPotion || po instanceof com.megacrit.cardcrawl.potions.LiquidMemories || po instanceof pokemonmaster.Potions.BleakStone|| po instanceof pokemonmaster.Potions.FireStone || po instanceof pokemonmaster.Potions.LeafStone || po instanceof pokemonmaster.Potions.MindStone || po instanceof pokemonmaster.Potions.ThunderStone || po instanceof pokemonmaster.Potions.WaterStone)
                po = AbstractDungeon.returnRandomPotion(true);
            AbstractPlayer abstractPlayer = AbstractDungeon.player;
            if (po.isThrown && po.targetRequired)
                this.target = AbstractDungeon.getRandomMonster();
            po.use(this.target);
        }
        this.isDone=true;
    }
}
