package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Wound;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Crash extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Crash",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);






    public Crash() {
        super(cardInfo);
        tags.add(CustomTags.CHOICE);
    }

    @Override


    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();

    }

    public void onChoseThisOption() {
        addToBot(new MakeTempCardInHandAction(new Wound(),1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Crash();
    }
}

