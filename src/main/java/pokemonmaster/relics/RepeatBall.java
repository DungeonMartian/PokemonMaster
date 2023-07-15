package pokemonmaster.relics;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.jar.PokemonMaster;

import java.util.function.Predicate;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RepeatBall extends BaseRelic implements ClickableRelic {
    private static final String NAME = "RepeatBall"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.


    public RepeatBall() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
        this.counter = 1;

    }

    public void setCounter(int setCounter) {
        this.counter = setCounter;
        if (setCounter == -1) {
            usedUp();
            this.counter = -1;
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
    public void atBattleStart() {
        if (this.counter ==0) {
            this.grayscale = true;
        }
    }
    @Override
    public void onRightClick() {
        if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
            if (this.counter > 0) {
                flash();
                this.grayscale = true;
                addToBot(new SelectCardsInHandAction(1, "copy", false, false, (Predicate<AbstractCard>) card -> true, abstractCards -> {
                    for (AbstractCard i : abstractCards) {
                        addToBot(new AddCardToDeckAction(i.makeCopy()));
                    }
                }));
                this.counter -= 1;
            }
        }
}}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
