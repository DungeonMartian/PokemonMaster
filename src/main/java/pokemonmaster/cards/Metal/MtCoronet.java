package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.MtCoronetPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MtCoronet extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MtCoronet",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGS = 1;
    private static final int MAGSUP = 1;




    public MtCoronet() {
        super(cardInfo);
        setMagic(MAGS, MAGSUP);
        tags.add(CustomTags.METAL);
        this.cardsToPreview = new Magnet();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }




    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new MtCoronetPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MtCoronet();
    }
}

