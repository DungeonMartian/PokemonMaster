package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.StatusDiscardBlock;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magmar extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magmar",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FIRE = 2;
    private static final int FIREUP = 1;



    public Magmar() {
        super(cardInfo);
        setMagic(FIRE,FIREUP);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        purgeOnUse = true;
        this.cardsToPreview = new Magmortar();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p, new StatusDiscardBlock(p,magicNumber)));
        addToBot(new MakeTempCardInDiscardAction(new Magmortar(), 1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magmar();
    }
}

