package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.CoatingEnergyPower;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CoatingEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CoatingEnergy",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int ARTY = 1;
    private static final int ARTYUP = 1;

    public CoatingEnergy() {
        super(cardInfo);
        tags.add(CustomTags.METAL);
        setMagic(ARTY,ARTYUP);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new CoatingEnergyPower(p,magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new ArtifactPower(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new CoatingEnergy();
    }
}

