package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class JawWorm extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "JawWorm",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int BELLOW = 3;
    private static final int UPG_BELLOW= 2;
    private static final int BLOCK = 6;
    private static final int UPG_BLOCK= 3;


    public JawWorm() {
        super(cardInfo);
        setBlock(BLOCK,UPG_BLOCK);
        setMagic(BELLOW, UPG_BELLOW);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new JawWorm();
    }
}

