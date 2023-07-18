package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanMeowth extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanMeowth",
            1,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC= 1;


    public AlolanMeowth() {
        super(cardInfo,new AlolanPersian(),new AlolanPersian(),CustomTags.DARK);
        setBlock(BLOCK);
        setMagic(MAGIC,UPG_MAGIC);


        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(m, p, new WeakPower(m, magicNumber, false)));
        addToBot(new DiscardAction(p,p,p.hand.size(),true));
        addToBot(new DrawCardAction(p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AlolanMeowth();
    }
}

