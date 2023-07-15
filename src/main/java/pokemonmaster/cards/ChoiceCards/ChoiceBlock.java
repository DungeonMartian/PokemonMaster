package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ChoiceBlock extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;



    public ChoiceBlock() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.CHOICE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ChoiceBlock();
    }
}

