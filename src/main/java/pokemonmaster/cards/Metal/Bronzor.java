package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.MagExhaustPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Bronzor extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Bronzor",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;
    private static final int MAGEX= 1;
    private static final int MAGEXUP= 1;


    public Bronzor() {
        super(cardInfo,new Bronzong(),new Bronzong(),CustomTags.METAL);
        setBlock(BLOCK);
        setMagic(MAGEX, MAGEXUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInHandAction(new Magnet(), 1));
        addToBot(new ApplyPowerAction(p, p, new MagExhaustPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bronzor();
    }
}

