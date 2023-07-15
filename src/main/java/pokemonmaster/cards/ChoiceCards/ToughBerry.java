package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ToughBerry extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ToughBerry",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9;//if you change these remember to change the parent
    private static final int UPG_BLOCK = 3;





    public ToughBerry() {
        super(cardInfo);
        setBlock(BLOCK,UPG_BLOCK);

    }

    @Override


    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new GainBlockAction(p, p, block));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ToughBerry();
    }
}

