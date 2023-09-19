package pokemonmaster;


import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatches;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.neow.NeowEvent;
import pokemonmaster.cards.Metal.Magnet;
import pokemonmaster.cards.Water.FishingCards.Cursola;
import pokemonmaster.jar.PokemonMaster;

@SpirePatches({@SpirePatch(clz = NeowEvent.class, method = "update"), @SpirePatch(cls = "downfall.events.HeartEvent", method = "update", optional = true)})
public class OpeningRunScreenPatch {
    public static class BeginNeowEvent {

        @SpirePrefixPatch
        public static void ChangeEventIfPokemon(NeowEvent __instance, boolean isDone) {
            if ((AbstractDungeon.player.chosenClass == PokemonMaster.Enums.POKE_MASTER)) {

                CardGroup RUNTYPEs = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                RUNTYPEs.addToTop(new Cursola());
                RUNTYPEs.addToTop(new Slimed());
                RUNTYPEs.addToTop(new Magnet());



                AbstractDungeon.gridSelectScreen.open(RUNTYPEs, 3, true, "bree");
                CardCrawlGame.dungeon.initializeCardPools();


            }
        }
    }


}