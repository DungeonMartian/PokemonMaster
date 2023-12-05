package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.FocusSashPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FocusSash extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FocusSash",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FIGHT = 10;
    private static final int FIGHTUP = 14;



    public FocusSash() {
        super(cardInfo);
        setMagic(FIGHT,FIGHTUP);
        tags.add(CustomTags.FIGHTING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");
        tags.add(CardTags.HEALING);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new ApplyPowerAction(p, p, new FocusSashPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FocusSash();
    }
}

