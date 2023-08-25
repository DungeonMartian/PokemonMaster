package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanDiglet extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanDiglet",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 3;
    private static final int UPG_BLOCK= 2;
    private static final int SCRY = 3;
    private static final int SCRYUP= 2;



    public AlolanDiglet() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(SCRY, SCRYUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        purgeOnUse = true;
        this.cardsToPreview = new AlolanDugtrio();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ScryAction(this.magicNumber));
        if (upgraded) {
            AbstractCard s = (new AlolanDugtrio()).makeCopy();
            s.upgrade();
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(s, 1, false, true));
        }
        else {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new AlolanDugtrio(), 1, false, true));
        }
    }
    public void upgrade() {
        this.cardsToPreview.upgrade();
        super.upgrade();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new AlolanDiglet();
    }
}

