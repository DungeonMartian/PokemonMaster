package pokemonmaster.cards.Base;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RareCandy extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RareCandy",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int EVOLVE = 1;



    public RareCandy() {
        super(cardInfo);
        setMagic(EVOLVE);
        this.exhaust=true;
        setCostUpgrade(0);
        setSelfRetain(true,true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SelectCardsInHandAction(magicNumber, "evolve",false,false, card -> card.hasTag(CustomTags.POKEMON) && (card.cardsToPreview != null || !card.upgraded), abstractCards -> {
        for (AbstractCard i : abstractCards) {
            addToBot(new EvolveActionCombat(i, "hand"));
        }
        }));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RareCandy();
    }
}

