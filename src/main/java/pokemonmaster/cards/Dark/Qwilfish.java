package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ToxicSpikes;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Qwilfish extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Qwilfish",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 2;
    private static final int MAGIC = 2;




    public Qwilfish() {
        super(cardInfo,new Overqwil(),new Overqwil(),CustomTags.DARK);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new ToxicSpikes(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Qwilfish();
    }
}

