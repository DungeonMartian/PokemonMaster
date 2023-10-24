package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class StrongEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "StrongEnergy",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int STRENGTH =1;
    private static final int UPG_STRENGTH =2;
    public StrongEnergy() {
        super(cardInfo);
        tags.add(CustomTags.FIGHTING);
        setMagic(STRENGTH,UPG_STRENGTH);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new StrongEnergy();
    }
}

