package pokemonmaster.cards.StarterRelic.Act3;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Transient extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Transient",
            4,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public Transient() {
        super(cardInfo);
        setCostUpgrade(4);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new AddTemporaryHPAction(p,p,999));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Transient();
    }
}

