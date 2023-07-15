package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AngerPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GremlinNob extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GremlinNob",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int ANGER = 1;
    private static final int UPG_ANGER= 1;



    public GremlinNob() {
        super(cardInfo);
        setMagic(ANGER, UPG_ANGER);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new AngerPower(p, magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GremlinNob();
    }
}

