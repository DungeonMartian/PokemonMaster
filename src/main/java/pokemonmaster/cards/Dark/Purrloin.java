package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Purrloin extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Purrloin",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;



    public Purrloin() {
        super(cardInfo,new Liepard(),new Liepard(),CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(p, this.magicNumber));
        addToBot(new DiscardAction(p, p, this.magicNumber, false));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Purrloin();
    }
}

