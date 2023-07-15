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

public class SuperRod extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SuperRod",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    public static  int FISHINGPOWER = 40;


    public SuperRod() {
        super(cardInfo);
        tags.add(CustomTags.WATER);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");
        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new FishAction(0, FISHINGPOWER));



    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SuperRod();
    }
}

