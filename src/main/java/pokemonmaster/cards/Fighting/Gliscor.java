package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gliscor extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gliscor",
            3,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 15;
    private static final int BLOCKUP = 5;
    private static final int POISON = 14;
    private static final int POISONUP = 5;



    public Gliscor() {
        super(cardInfo,CustomTags.FIGHTING);
        setBlock(BLOCK,BLOCKUP);
        setMagic(POISON,POISONUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gliscor();
    }
}

