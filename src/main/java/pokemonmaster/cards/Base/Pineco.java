package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pineco extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pineco",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;
    private static final int UPG_BLOCK= 2;



    public Pineco() {
        super(cardInfo);
        tags.add(CustomTags.POKEMON);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        //tags.add(CardTags.STARTER_DEFEND);
        purgeOnUse = true;
        this.cardsToPreview = new Forretress();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInDiscardAction(new Forretress(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pineco();
    }
}

