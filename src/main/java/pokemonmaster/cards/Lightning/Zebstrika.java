package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zebstrika extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zebstrika",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DRAW = 4;
    private static final int UPG_DRAW= 2;



    public Zebstrika() {
        super(cardInfo,CustomTags.LIGHTNING);
        setMagic(DRAW, UPG_DRAW);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DiscardAction(p,p,p.hand.size(),true));
        addToBot(new DrawCardAction(p,magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zebstrika();
    }
}

