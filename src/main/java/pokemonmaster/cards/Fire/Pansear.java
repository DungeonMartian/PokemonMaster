package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pansear extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pansear",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DRAWF = 1;
    private static final int DRAWFUP = 1;



    public Pansear() {
        super(cardInfo,new Simisear(),new Simisear(),CustomTags.FIRE);
        setMagic(DRAWF, DRAWFUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(magicNumber));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pansear();
    }
}

