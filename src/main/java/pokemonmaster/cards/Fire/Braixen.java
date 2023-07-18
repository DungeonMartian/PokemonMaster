package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Burned;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Braixen extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Braixen",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;
    private static final int UPG_BLOCK= 2;
    private static final int WEAK = 1;
    private static final int UPG_WEAK= 1;


    public Braixen() {
        super(cardInfo,new Delphox(),CustomTags.FIRE);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(WEAK,UPG_WEAK);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(m, p, new Burned(m,2)));
        addToBot(new ApplyPowerAction(m, p, new WeakPower(m,magicNumber,false)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Braixen();
    }
}

