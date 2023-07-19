package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magneton extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magneton",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGNET = 2;
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;





    public Magneton() {
        super(cardInfo,new Magnezone(),CustomTags.METAL);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGNET);
        purgeOnUse = true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInHandAction(new Magnet(), magicNumber));

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magneton();
    }
}

