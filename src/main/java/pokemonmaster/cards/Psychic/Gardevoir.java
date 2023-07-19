package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardTarget;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
// import pokemonmaster.cards.PokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gardevoir extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gardevoir",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 10;
    private static final int UPG_BLOCK = 8;


    public Gardevoir() {
        super(cardInfo, CustomTags.PSYCHIC);
        setBlock(BLOCK, UPG_BLOCK);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        // discard a card from your hand, if you do, draw 2 cards
        boolean hadCards = p.hand.size() > 0;
        addToBot(new DiscardAction(p, p, 1, false));
        if (hadCards) {
            addToBot(new DrawCardAction(p, 2));
        }
    }
}

