package pokemonmaster.Potions;

import basemod.abstracts.CustomPotion;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.util.Actions.CatchAction;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ParkBall extends CustomPotion {
    public static final String POTION_ID = makeID("ParkBall");

    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public static final String NAME = potionStrings.NAME;

    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public ParkBall() {
        super(NAME, POTION_ID, PotionRarity.RARE, PotionSize.FAIRY, PotionColor.NONE);
        this.potency = getPotency();
        this.labOutlineColor = Color.YELLOW.cpy();

            this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];

        this.isThrown = true;
        this.targetRequired = true;
        this.tips.add(new PowerTip(this.name, this.description));
    }

    public void use(AbstractCreature target) {
        if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
            addToBot(new CatchAction(target,new DamageInfo(AbstractDungeon.player, this.potency, DamageInfo.DamageType.HP_LOSS)));
        }
    }

    public AbstractPotion makeCopy() {
        return new ParkBall();
    }

    public int getPotency(int potency) {
        return 5;
    }
}
