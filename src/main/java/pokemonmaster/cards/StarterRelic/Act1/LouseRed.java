package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.CurlUpPokemonPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LouseRed extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LouseRed",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int CURL = 2;
    private static final int UPG_CURl= 2;


    public LouseRed() {
        super(cardInfo);

        setMagic(CURL,UPG_CURl);
        tags.add(CustomTags.BAIT);
        this.misc=35;

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new CurlUpPokemonPower(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LouseRed();
    }
}

