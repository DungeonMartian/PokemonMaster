package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Guardian extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Guardian",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int BLOCK = 20;
    private static final int THORNS = 4;

    public Guardian() {
        super(cardInfo);
        setBlock(BLOCK);
        setMagic(THORNS);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BlurPower(p, 2)));
        addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, magicNumber)));
        if (this.upgraded) {
            addToBot(new GainBlockAction(p, p, block));

        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Guardian();
    }
}

