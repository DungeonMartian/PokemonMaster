package pokemonmaster.relics;

import pokemonmaster.TypeRemoverClass;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class PuzzleCube extends BaseRelic  {
    private static final String NAME = "PuzzleCube"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.MAGICAL; //The sound played when the relic is clicked.


    public PuzzleCube() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);

    }

    @Override
    public void onEquip() {
        TypeRemoverClass.DOTHIS=true;
        TypeRemoverClass.removeCards();
        super.onEquip();
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
