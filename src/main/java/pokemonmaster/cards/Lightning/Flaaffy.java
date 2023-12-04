package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Dynamotor;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Flaaffy extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Flaaffy",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int MAGIC = 1;


    public Flaaffy() {
        super(cardInfo, new Ampharos(), CustomTags.LIGHTNING);
        setMagic(MAGIC);
        setCostUpgrade(1);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerLightning.png","pokemonmaster/character/cardback/bg_powerLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Dynamotor(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Flaaffy();
    }
}

