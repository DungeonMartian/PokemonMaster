package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;

import static pokemonmaster.PokemonMasterMod.makeID;
public class ShortFuse extends BaseRelic {
    private static final String NAME = "ShortFuse"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.


    public ShortFuse() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public void onPlayerEndTurn() {
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
            AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
            AbstractDungeon.player.discardPile.moveToExhaustPile(card);

                }
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new Spark(AbstractDungeon.player, 1)));

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
