package pokemonmaster.cards.Base;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.PokeDollPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class PokeDoll extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PokeDoll",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int TEMPHE = 30;
    private static final int TEMPHEUP= 20;



    public PokeDoll() {
        super(cardInfo);
        setMagic(TEMPHE, TEMPHEUP);
        tags.add(CardTags.HEALING);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new PokeDollPower(p,1)));
        addToBot(new AddTemporaryHPAction(p, p, magicNumber));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new PokeDoll();
    }
}

