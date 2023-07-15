package pokemonmaster.cards.Fighting;

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

public class StoneEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "StoneEnergy",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int SHIELD =2;
    private static final int SHIELDUP =2;
    public StoneEnergy() {
        super(cardInfo);
        tags.add(CustomTags.FIGHTING);
        setMagic(SHIELD,SHIELDUP);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new ShieldEnergyPower(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new StoneEnergy();
    }
}

