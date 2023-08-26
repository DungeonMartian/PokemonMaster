package pokemonmaster.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.OnReceivePowerRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.RegenPower;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MooMooMilk extends BaseRelic implements OnReceivePowerRelic {
    private static final String NAME = "MooMooMilk"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.


    public MooMooMilk() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }


    public void atBattleStart() {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RegenPower(AbstractDungeon.player, 1)));

    }
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public boolean onReceivePower(AbstractPower abstractPower, AbstractCreature abstractCreature) {
        if (abstractPower.ID.equals(RegenPower.POWER_ID)) {
            abstractPower.amount += 1;
            flash();
        }
        return true;
    }

    @Override
    public int onReceivePowerStacks(AbstractPower power, AbstractCreature source, int stackAmount) {
        if (power.ID.equals(RegenPower.POWER_ID)) {
            flash();
            return OnReceivePowerRelic.super.onReceivePowerStacks(power, source, stackAmount + 1);
        } else {
            return OnReceivePowerRelic.super.onReceivePowerStacks(power, source, stackAmount);
        }
    }
}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
