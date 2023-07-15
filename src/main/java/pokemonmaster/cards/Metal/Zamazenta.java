package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ZamazentaPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zamazenta extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zamazenta",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    public static int ZAMNUM =3;
    public static int ZAMNUP =2;
    public Zamazenta() {
        super(cardInfo);
        tags.add(CustomTags.POKEMON);
        setMagic(ZAMNUM,ZAMNUP);
        tags.add(CustomTags.METAL);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ZamazentaPower(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zamazenta();
    }
}

