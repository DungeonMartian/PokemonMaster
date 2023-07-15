package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RockyHelmet extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RockyHelmet",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGEXHAUST = 3;
    private static final int MAGEXHAUSTUP = 2;





    public RockyHelmet() {
        super(cardInfo);
        setMagic(MAGEXHAUST, MAGEXHAUSTUP);

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ThornsPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RockyHelmet();
    }
}

