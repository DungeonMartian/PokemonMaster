package pokemonmaster.Potions;

import basemod.abstracts.CustomPotion;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.util.Actions.FishAction;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DiveBall extends CustomPotion {
    public static final String POTION_ID = makeID("DiveBall");

    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public static final String NAME = potionStrings.NAME;

    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;


    public DiveBall() {
        super(NAME, POTION_ID, PotionRarity.RARE, PotionSize.FAIRY, PotionColor.NONE);
        this.potency = getPotency();
        this.labOutlineColor = Color.YELLOW.cpy();

            this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];

        this.tips.add(new PowerTip(this.name, this.description));

    }

    public void use(AbstractCreature target) {
        if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {


                addToBot(new FishAction(0, this.potency, true));

        }
    }

    public AbstractPotion makeCopy() {
        return new DiveBall();
    }

    public int getPotency(int potency) {
        return 45;
    }
}
