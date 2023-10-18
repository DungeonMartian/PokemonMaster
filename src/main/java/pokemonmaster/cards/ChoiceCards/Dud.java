package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Dud extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Dud",
            0,
            CardType.STATUS,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            AbstractCard.CardColor.COLORLESS);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;




    public Dud() {
        super(cardInfo);
        setBlock(BLOCK);
        this.exhaust=true;


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(new GainBlockAction(p,block));
            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Dud();
    }
}

