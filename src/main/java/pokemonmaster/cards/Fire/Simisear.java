package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Simisear extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Simisear",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DRAWF = 3;




    public Simisear() {
        super(cardInfo,CustomTags.FIRE);
        setMagic(DRAWF);
        setCostUpgrade(0);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Simisear();
    }
}

