package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GalarianFarfetchd extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GalarianFarfetch'd",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FARFETC = 2;
    private static final int FARFECTUP = 3;



    public GalarianFarfetchd() {
        super(cardInfo);
        setMagic(FARFETC, FARFECTUP);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.FIGHTING);
        tags.add(CardTags.HEALING);
        purgeOnUse = true;
        this.cardsToPreview = new GalarianSirfetchd();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
        addToBot(new HealAction(p, p, this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new GalarianSirfetchd(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GalarianFarfetchd();
    }
}

