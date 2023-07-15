package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class QuickClaw extends BaseRelic  {
    private static final String NAME = "QuickClaw"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.UNCOMMON; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    private boolean TODO = true;
    public QuickClaw() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onManualDiscard() {
        super.onManualDiscard();
        if (TODO){
            addToBot(new DrawCardAction(2));
        }
        TODO = false;
    }

    @Override
    public void onPlayerEndTurn() {
        super.onPlayerEndTurn();
        TODO = true;
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
