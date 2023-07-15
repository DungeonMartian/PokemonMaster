package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.XatuScryAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Xatu extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Xatu",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;
    private static final int XATUSCRY = 5;
    private static final int XATUSCRYUP= 1;



    public Xatu() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(XATUSCRY,XATUSCRYUP);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new XatuScryAction(magicNumber));
        AbstractCard s = (new Natu()).makeCopy();
        if (this.upgraded) {
            s.upgrade();
        }
        addToBot(new MakeTempCardInDiscardAction(s,1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Xatu();
    }
}

