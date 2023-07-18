package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shuppet extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Shuppet",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int SHUPPDRAW = 2;
    private static final int SHUPPDRAWUP= 1;



    public Shuppet() {
        super(cardInfo,new Banette(),new Banette(),CustomTags.PSYCHIC);
        setMagic(SHUPPDRAW, SHUPPDRAWUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ExhaustAction(1, false));
        addToBot(new DrawCardAction(p, this.magicNumber));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shuppet();
    }
}

