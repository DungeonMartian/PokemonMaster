package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.CustomTags;
import pokemonmaster.jar.PokemonMaster;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pokedex extends BaseRelic  {
    private static final String NAME = "Pokedex"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.MAGICAL; //The sound played when the relic is clicked.

    ArrayList<AbstractCard> Added = new ArrayList<>();
    public Pokedex() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);

    }

    public void setCounter(int setCounter) {
        this.counter = setCounter;

    }

    @Override
    public void atBattleStart() {
        this.counter=1;
        this.usedUp = false;
        for (AbstractCard j : AbstractDungeon.player.masterDeck.group){
            if (j.hasTag(CustomTags.POKEMON)) {
                if (!Added.contains(j)) {
                    Added.add(j);
                }
            }
        }
        this.counter+= Added.size()/3;
        super.atBattleStart();
    }

    @Override
    public void atTurnStart() {
        if (this.counter >=0) {
            addToBot(new DrawCardAction(AbstractDungeon.player, 1));
            addToBot(new GainEnergyAction(1));
            this.counter -= 1;
        }
        if (this.counter <=0){
            this.usedUp = true;
        }
        super.atTurnStart();
    }

    @Override
    public void onEnterRoom(AbstractRoom room) {
        this.counter = -1;
        this.usedUp=false;
        super.onEnterRoom(room);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] ;
    }


}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
