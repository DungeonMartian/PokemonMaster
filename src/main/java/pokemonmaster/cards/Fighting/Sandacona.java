package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sandacona extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sandaconda",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 16;
    private static final int BLOCKUP = 3;
    private static final int SILIDEX= 1;



    public Sandacona() {
        super(cardInfo,CustomTags.FIGHTING);
        setBlock(BLOCK,BLOCKUP);
        setMagic(SILIDEX);

        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sandacona();
    }
}

