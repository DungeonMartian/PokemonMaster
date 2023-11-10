package pokemonmaster.cards.Base;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Evosoda extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Evosoda",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int EVOLVE = 1;



    public Evosoda() {
        super(cardInfo);
        setMagic(EVOLVE);
        setCostUpgrade(0);
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 2);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SelectCardsInHandAction(magicNumber, "evolve",false,false, card -> card.hasTag(CustomTags.POKEMON) && (card.cardsToPreview != null || !card.upgraded), abstractCards -> {
        for (AbstractCard i : abstractCards) {
            addToBot(new EvolveActionCombat(i, AbstractDungeon.player.hand));
        }
        }));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Evosoda();
    }
}

