package pokemonmaster.relics;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HotPotato extends BaseRelic {
    private static final String NAME = "HotPotato"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.FLAT; //The sound played when the relic is clicked.


    public HotPotato() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }


    @Override
    public void onExhaust(AbstractCard card) {
        super.onExhaust(card);
        addToBot(new AddTemporaryHPAction(AbstractDungeon.player, AbstractDungeon.player, 1));
    }
}


    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
