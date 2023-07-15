package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HorrorEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HorrorEnergy",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int THORNS = 4;
    private static final int UPG_THORNS = 2;
    public HorrorEnergy() {
        super(cardInfo);
        tags.add(CustomTags.PSYCHIC);
        setCostUpgrade(0);
        setMagic(THORNS,UPG_THORNS);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerPsychic.png","pokemonmaster/character/cardback/bg_powerPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ThornsPower(p,magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new HorrorEnergy();
    }
}
