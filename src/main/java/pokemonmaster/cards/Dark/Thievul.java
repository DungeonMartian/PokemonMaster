package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Thievul extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Thievul",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;

    private static final int UPG_MAGIC = 1;


    public Thievul() {
        super(cardInfo,CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDiscardPileToHandAction(magicNumber));
        addToBot(new DiscardAction(p, p, this.magicNumber, false));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Thievul();
    }
}

