package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.BronzongPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Bronzong extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Bronzong",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGEXHAUST = 1;
    private static final int MAGEXHAUSTUP = 1;





    public Bronzong() {
        super(cardInfo,CustomTags.METAL);
        setMagic(MAGEXHAUST, MAGEXHAUSTUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }




    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Magnet(), 1));
        addToBot(new ApplyPowerAction(p, p, new BronzongPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bronzong();
    }
}

