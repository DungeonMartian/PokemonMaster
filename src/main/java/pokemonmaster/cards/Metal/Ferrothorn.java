package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Ferrothorn extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Ferrothorn",
            4,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;



    public Ferrothorn() {
        super(cardInfo,CustomTags.METAL);
        setBlock(BLOCK, UPG_BLOCK);
        setCostUpgrade(3);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Ferrothorn();
    }
}

