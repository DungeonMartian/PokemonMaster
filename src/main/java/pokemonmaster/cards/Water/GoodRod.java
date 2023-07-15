package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.FishAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GoodRod extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GoodRod",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    public static  int FISHINGPOWER = 30;

    public GoodRod() {
        super(cardInfo);
        tags.add(CustomTags.WATER);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");
        setCostUpgrade(0);
    }

        @Override
        public void use (AbstractPlayer p, AbstractMonster m){


            addToBot(new FishAction(0, FISHINGPOWER));

        }








    @Override
    public AbstractCard makeCopy() { //Optional
        return new GoodRod();
    }
}

