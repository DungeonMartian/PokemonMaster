package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magnezone extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magnezone",
            -1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGNET = 2;


    public Magnezone() {
        super(cardInfo,CustomTags.METAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGNET);

        this.isMultiDamage = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
        addToBot(new MakeTempCardInHandAction(new Magnet(), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magnezone();
    }
}

