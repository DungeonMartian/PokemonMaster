package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Blunder extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Blunder",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);






    public Blunder() {
        super(cardInfo);
        tags.add(CustomTags.CHOICE);
    }

    @Override


    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();

    }

    public void onChoseThisOption() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Dazed(), 1, false, true));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Blunder();
    }
}

