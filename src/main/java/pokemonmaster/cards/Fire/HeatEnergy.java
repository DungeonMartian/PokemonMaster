package pokemonmaster.cards.Fire;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HeatEnergy extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HeatEnergy",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int SHIELD =10;

    public HeatEnergy() {
        super(cardInfo);
        setInnate(false,true);
        tags.add(CustomTags.FIRE);
        setMagic(SHIELD);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,1)));
        addToBot(new AddTemporaryHPAction(p, p, magicNumber));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new HeatEnergy();
    }
}

