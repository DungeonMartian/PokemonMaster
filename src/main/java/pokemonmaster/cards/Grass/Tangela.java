package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NoxiousFumesPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tangela extends BaseCard {




    private final static CardInfo cardInfo = new CardInfo(
            "Tangela",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int POISONTURN = 1;
    private static final int POISONTURNUP = 1;


    public Tangela() {
        super(cardInfo);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.EVOLVED);
        setMagic(POISONTURN,POISONTURNUP);
        tags.add(CustomTags.POKEMON);
        this.cardsToPreview = new Tangrowth();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new NoxiousFumesPower(p,magicNumber)));
        addToBot(new MakeTempCardInDiscardAction(new Tangrowth(), 1));
    }



    @Override
    public AbstractCard makeCopy() { //Optional
        return new Tangela();
    }
}

