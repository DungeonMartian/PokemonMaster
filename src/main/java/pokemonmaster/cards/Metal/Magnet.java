package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magnet extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magnet",
            0,
            CardType.STATUS,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            AbstractCard.CardColor.COLORLESS);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int ENERGY = 1;




    public Magnet() {
        super(cardInfo);
        this.selfRetain = true;
        setMagic(ENERGY);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.BAIT);
        this.misc =10;
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainEnergyAction(magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magnet();
    }
}

