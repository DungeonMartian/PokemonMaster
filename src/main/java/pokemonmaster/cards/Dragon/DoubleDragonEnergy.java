package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DoubleDragonEnergy extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DoubleDragonEnergy",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;




    public DoubleDragonEnergy() {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CustomTags.DRAGON);
        setInnate(false,true);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerDragon.png","pokemonmaster/character/cardback/bg_powerDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new EnergyPower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DoubleDragonEnergy();
    }
}

