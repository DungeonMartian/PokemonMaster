package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class TwistedSpoon extends BaseRelic  {
    private static final String NAME = "TwistedSpoon"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.UNCOMMON; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.MAGICAL; //The sound played when the relic is clicked.

    public TwistedSpoon() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
        this.counter = 0;
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (this.counter >= 0) {

            this.counter++;

            if (this.counter == 10) {
                flash();
                this.pulse = false;
                addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                addToTop(new HealAction(AbstractDungeon.player, AbstractDungeon.player, 8));
                this.counter = -1;
                this.grayscale = true;
            } else if (this.counter == 9) {
                beginPulse();
                this.pulse = true;
            }
        }
    }


    public void onVictory() {
        this.counter = -1;
        this.grayscale = false;
    }
    public void atBattleStart() {
        this.counter = 0;
        this.grayscale = false;
    }

    @Override
    public void onPlayerEndTurn() {
        if (this.counter >0){
            this.counter=0;
        }
        super.onPlayerEndTurn();
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
