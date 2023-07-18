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
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanPersian extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanPersian",
            1,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;
    private static final int UPG_BLOCK= 2;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC= 1;


    public AlolanPersian() {
        super(cardInfo,CustomTags.DARK);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.POKEMON);
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
        return new AlolanPersian();
    }
}

