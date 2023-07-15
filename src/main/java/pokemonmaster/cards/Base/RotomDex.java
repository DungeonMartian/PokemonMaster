package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RotomDex extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RotomDex",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int SCRY = 6;
    private static final int SCRYUP= 2;



    public RotomDex() {
        super(cardInfo);
        setMagic(SCRY, SCRYUP);
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ScryAction(this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RotomDex();
    }
}

