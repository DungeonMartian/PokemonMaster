package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pokemonmaster.cards.ChoiceCards.BulletSeed;
import pokemonmaster.cards.Metal.GholdengoCoin;
import pokemonmaster.cards.Metal.Magnet;
import pokemonmaster.cards.StarterRelic.Act1.*;
import pokemonmaster.cards.Water.*;
import pokemonmaster.jar.PokemonMaster;

import java.util.ArrayList;
import java.util.Random;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.cardRandomRng;
import static pokemonmaster.PokemonMasterMod.makeID;

public class FishingKit extends BaseRelic  {
    private static final String NAME = "FishingKit"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.SHOP; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.HEAVY; //The sound played when the relic is clicked.


    public FishingKit() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] ;
    }
    public void atBattleStart() {
        this.flash();
        this.grayscale = true;
        ArrayList<AbstractCard> FISHINGROD = new ArrayList<>();
        FISHINGROD.add(new OldRod());
        FISHINGROD.add(new GoodRod());
        FISHINGROD.add(new SuperRod());

        ArrayList<AbstractCard> BAIT = new ArrayList<>();
        BAIT.add(new Magnet());
        BAIT.add(new Snom());
        BAIT.add(new ShiningMagikarp());
        BAIT.add(new BulletSeed());
        BAIT.add(new Tatsugiri());
        BAIT.add(new GholdengoCoin());
        BAIT.add(new SSlimeS());
        BAIT.add(new ASlimeS());
        BAIT.add(new SSlimeM());
        BAIT.add(new ASlimeM());
        BAIT.add(new LouseRed());
        BAIT.add(new LouseGreen());


        Random random = new Random();
        random.setSeed(cardRandomRng.randomLong());
        int RODHAND = random.nextInt((FISHINGROD.size()+1) - 1) + 1;

        Random random2 = new Random();
        random2.setSeed(cardRandomRng.randomLong());
        int BAITHAND = random2.nextInt((BAIT.size()+1) - 1) + 1;

        Random random3 = new Random();
        random3.setSeed(cardRandomRng.randomLong());
        int BAITHAND2 = random3.nextInt((BAIT.size()+1) - 1) + 1;

        addToBot(new MakeTempCardInHandAction(FISHINGROD.get(RODHAND-1)));
        addToBot(new MakeTempCardInHandAction(BAIT.get(BAITHAND-1)));
        addToBot(new MakeTempCardInHandAction(BAIT.get(BAITHAND2-1)));
    }



    public void justEnteredRoom(AbstractRoom room) {
        this.grayscale = false;
    }
}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
