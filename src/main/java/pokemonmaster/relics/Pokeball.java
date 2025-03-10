package pokemonmaster.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.PokemonMasterMod;
import pokemonmaster.jar.PokemonMaster;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pokeball extends BaseRelic implements ClickableRelic {
    private static final String NAME = "Pokeball"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.STARTER; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.


    public Pokeball() {
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
    public static ArrayList<AbstractMonster> getEnemies() {
        ArrayList<AbstractMonster> monsters = new ArrayList<>(AbstractDungeon.getMonsters().monsters);
        monsters.removeIf(AbstractMonster::isDeadOrEscaped);
        return monsters;
    }
    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        super.onPlayCard(c, m);
        if (!this.grayscale) {
            boolean flashing = false;
            for (AbstractMonster mmonster : getEnemies()) {


                if (mmonster.currentHealth <= 10) {
                    flashing = true;
                    this.beginPulse();
                    this.pulse = true;
                }
                if (!flashing){
                    this.stopPulse();
                    this.pulse = false;
                }

                }
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] ;
    }
    public void atBattleStart() {
        if (this.counter ==0) {
            this.grayscale = true;
        }
    }
    @Override
    public void onEnterRoom(AbstractRoom room) {
        if (PokemonMasterMod.PokeButton.toggle.enabled) {
            this.counter = 1;
            this.usedUp=false;
            this.grayscale = false;
            
        }
        super.onEnterRoom(room);
    }
    @Override
    public void onRightClick() {
        if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
            if (this.counter > 0) {
                flash();
                this.grayscale = true;
                addToBot(new MakeTempCardInHandAction(new pokemonmaster.cards.StarterRelic.Pokeball(), 1));
                this.counter -= 1;
            }
        }
}}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
