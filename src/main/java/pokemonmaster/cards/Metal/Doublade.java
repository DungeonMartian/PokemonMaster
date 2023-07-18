package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Doublade extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Doublade",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DEXT = 1;
    private static final int DEXTUP = 1;
    private static final int BLOCK = 12;
    private static final int UPG_BLOCK= 1;

    public Doublade() {
        super(cardInfo,new Aegislash(),CustomTags.METAL);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(DEXT,DEXTUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Doublade();
    }
}

