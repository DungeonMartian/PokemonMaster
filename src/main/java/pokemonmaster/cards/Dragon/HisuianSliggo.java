package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HisuianSliggo extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HisuianSliggo",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DLESS = 3;
    private static final int DLESSUP= 2;
    private static final int BLOCK = 3;
    private static final int BLOCKUP= 4;



    public HisuianSliggo() {
        super(cardInfo,new HisuianGoodra(),CustomTags.DRAGON);
        setBlock(BLOCK, BLOCKUP);
        setMagic(DLESS, DLESSUP);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));
        addToBot(new GainBlockAction(p, p, block));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HisuianSliggo();
    }
}

