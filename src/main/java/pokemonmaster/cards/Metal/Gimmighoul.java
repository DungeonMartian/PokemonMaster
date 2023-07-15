package pokemonmaster.cards.Metal;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gimmighoul extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gimmighoul",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int COINS = 2;
    private static final int COINSUP = 1;






    public Gimmighoul() {
        super(cardInfo);
        setMagic(COINS, COINSUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.EVOLVED);
        this.exhaust=true;
        this.cardsToPreview = new GholdengoCoin();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInDiscardAction(new GholdengoCoin(), this.magicNumber));
        int pmoney = p.gold;
        if (pmoney > 998){
            FleetingField.fleeting.set(this, true);
            addToBot(new AddCardToDeckAction(new Gholdengo()));
            addToBot(new MakeTempCardInDiscardAction(new Gholdengo(), 1));
            p.gold -= 999;
        }
        else {
            this.exhaust=true;
        }
        //

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gimmighoul();
    }
}

