package pokemonmaster.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.OnAnyPowerAppliedRelic;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;

import java.util.Objects;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MiracleSeed extends BaseRelic implements OnAnyPowerAppliedRelic {
    private static final String NAME = "MiracleSeed"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.


    public MiracleSeed() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }



    @Override
    public boolean onAnyPowerApply(AbstractPower abstractPower, AbstractCreature abstractCreature, AbstractCreature abstractCreature1) {
        if (abstractCreature == AbstractDungeon.player) {
            if (!Objects.equals(abstractPower.ID, Prized.POWER_ID)) {
                if (abstractPower.type == AbstractPower.PowerType.DEBUFF) {
                    abstractPower.amount -= 1;
                    if (abstractPower.amount ==0){
                        addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, abstractPower));

                    }
                    abstractPower.updateDescription();
                }
            }
        }
        if (abstractCreature != AbstractDungeon.player) {
            if (abstractPower.type == AbstractPower.PowerType.DEBUFF) {
                abstractPower.amount += 1;
            }
            abstractPower.updateDescription();
        }
        return true;
    }

    @Override
    public int onAnyPowerApplyStacks(AbstractPower power, AbstractCreature target, AbstractCreature source, int stackAmount) {
        if (target == AbstractDungeon.player){
            if (!Objects.equals(power.ID, Prized.POWER_ID)) {
                if (power.type == AbstractPower.PowerType.DEBUFF) {
                    power.updateDescription();
                    return OnAnyPowerAppliedRelic.super.onAnyPowerApplyStacks(power, target, source, stackAmount -1);
                }
            }
        }
        if (target != AbstractDungeon.player){
            if (power.type == AbstractPower.PowerType.DEBUFF){
                power.updateDescription();
                return OnAnyPowerAppliedRelic.super.onAnyPowerApplyStacks(power, target, source, stackAmount+1);
            }
        }
        power.updateDescription();
        return OnAnyPowerAppliedRelic.super.onAnyPowerApplyStacks(power, target, source, stackAmount);
    }
}

    // Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
