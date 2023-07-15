package pokemonmaster;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch2(clz = AbstractDungeon.class, method = "initializeCardPools")
public class PokemonTypeRemoverDungeon
{

    @SpirePostfixPatch
    public static void removeCards() {
        //TypeRemoverClass.removeCards();
        //TypeRemoverClass.DOTHIS = false;
    }

}
