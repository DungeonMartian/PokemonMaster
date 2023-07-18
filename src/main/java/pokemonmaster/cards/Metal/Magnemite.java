package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magnemite extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magnemite",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGNET = 2;
    private static final int MAGNETUP = 1;



    public Magnemite() {
        super(cardInfo,new Magneton(),new Magnezone(),CustomTags.METAL);
        setMagic(MAGNET, MAGNETUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Magnet(), this.magicNumber));

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magnemite();
    }
}

