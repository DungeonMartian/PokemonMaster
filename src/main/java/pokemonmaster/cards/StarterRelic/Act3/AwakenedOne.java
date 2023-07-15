package pokemonmaster.cards.StarterRelic.Act3;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.CreativeAIPower;
import com.megacrit.cardcrawl.powers.CuriosityPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AwakenedOne extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AwakenedOne",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;


    public AwakenedOne() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new CuriosityPower(p,1)));
        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new CreativeAIPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AwakenedOne();
    }
}

