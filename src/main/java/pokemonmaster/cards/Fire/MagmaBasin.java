package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.MagmaBasinPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MagmaBasin extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MagmaBasin",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;



    public MagmaBasin() {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CustomTags.FIRE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p,p, new MagmaBasinPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MagmaBasin();
    }
}

