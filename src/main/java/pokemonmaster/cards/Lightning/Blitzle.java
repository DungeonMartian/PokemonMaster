package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Blitzle extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Blitzle",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DRAW = 2;
    private static final int UPG_DRAW= 1;



    public Blitzle() {
        super(cardInfo);
        setMagic(DRAW, UPG_DRAW);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.purgeOnUse=true;
        this.cardsToPreview=new Zebstrika();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DiscardAction(p,p,1,false));
        addToBot(new DrawCardAction(p,magicNumber));
        addToBot(new MakeTempCardInDiscardAction(new Zebstrika(),1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Blitzle();
    }
}

