package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanGolem extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanGolem",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 12;
    private static final int UPG_BLOCK= 2;



    public AlolanGolem() {
        super(cardInfo,CustomTags.LIGHTNING);
        setBlock(BLOCK, UPG_BLOCK);

        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new Spark(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AlolanGolem();
    }
}

