package pokemonmaster.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ChoiceBand extends BaseRelic {
    private static final String NAME = "ChoiceBand"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.MAGICAL; //The sound played when the relic is clicked.



    public ChoiceBand() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);

    }

    public void atBattleStart() {
        this.counter = 0;
    }



    @Override
    public void onPlayerEndTurn() {
        super.onPlayerEndTurn();
        if (this.counter == 1) {
            addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            addToBot(new RemoveDebuffsAction(AbstractDungeon.player));
        }
        stopPulse();
        this.pulse = false;
        this.counter = 0;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    public void onVictory() {
        this.counter = -1;
        stopPulse();
        this.pulse = false;
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        super.onPlayCard(c, m);
        if (this.counter == 0) {
            beginPulse();
            this.pulse = true;
        }
        else {
            stopPulse();
            this.pulse = false;
        }
        this.counter++;
    }
}


// Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
