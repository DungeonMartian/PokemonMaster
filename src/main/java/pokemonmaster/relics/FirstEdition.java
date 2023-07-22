package pokemonmaster.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.jar.PokemonMaster;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FirstEdition extends BaseRelic {
    private static final String NAME = "FirstEdition"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.FLAT; //The sound played when the relic is clicked.



    public FirstEdition() {
        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);

    }

    public void onEquip() {
        CardCrawlGame.sound.play("GOLD_GAIN");
        for (AbstractCard j : AbstractDungeon.player.masterDeck.group){
            if (j.rarity == AbstractCard.CardRarity.RARE){
                AbstractDungeon.player.gainGold(100);

            }
            //if (j.name.contains(" V") ){
            //    AbstractDungeon.player.gainGold(100);
            //}
            //if (j.name.contains(" GX") ){
            //    AbstractDungeon.player.gainGold(100);
            //}
            //if (j.name.contains(" EX") ){
            //    AbstractDungeon.player.gainGold(100);
            //}
        }

    }

    public boolean canSpawn() {
        return ((AbstractDungeon.floorNum >= 5) &&
                !(AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.ShopRoom));
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }



}


// Take advantage of autocomplete!
    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
