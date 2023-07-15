package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ChesnaughtVPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ChesnaughtV extends BaseCard {




    private final static CardInfo cardInfo = new CardInfo(
            "ChesnaughtV",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int GREENANGRY = 2;

    private static final int GREENANGRYUP = 1;


    public ChesnaughtV() {
        super(cardInfo);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.EVOLVED);
        tags.add(CustomTags.POKEMON);
        setMagic(GREENANGRY,GREENANGRYUP);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new ApplyPowerAction(p, p, new ChesnaughtVPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ChesnaughtV();
    }
}

