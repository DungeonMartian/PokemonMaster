package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.powers.ShieldEnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ShieldEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShieldEnergy",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int SHIELD =2;
    private static final int SHIELDUP =2;
    public ShieldEnergy() {
        super(cardInfo);
        tags.add(CustomTags.METAL);
        setMagic(SHIELD,SHIELDUP);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new ShieldEnergyPower(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShieldEnergy();
    }
}

