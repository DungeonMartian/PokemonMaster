package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Nickit extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Nickit",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;




    public Nickit() {
        super(cardInfo,new Thievul(),new Thievul(),CustomTags.DARK);
        setMagic(MAGIC);



        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDiscardPileToHandAction(magicNumber));
        addToBot(new DiscardAction(p, p, this.magicNumber, false));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Nickit();
    }
}

