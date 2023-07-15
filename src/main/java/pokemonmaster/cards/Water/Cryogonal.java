package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CryogonalScryAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cryogonal extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cryogonal",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int CRYOSCRY = 4;
    private static final int UPG_CRYOSCRY = 2;



    public Cryogonal() {
        super(cardInfo);
        setMagic(CRYOSCRY,UPG_CRYOSCRY);
        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(new CryogonalScryAction(magicNumber));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cryogonal();
    }
}

