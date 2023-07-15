package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.CruelCharge;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GalarianArticuno extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GalarianArticuno",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int GALARMAGIC = 2;




    public GalarianArticuno() {
        super(cardInfo);
        setSelfRetain(false,true);
        setMagic(GALARMAGIC);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerPsychic.png","pokemonmaster/character/cardback/bg_powerPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ExhaustAction(magicNumber,false,false,false));
        addToBot(new ApplyPowerAction(p, p, new Spark(p,magicNumber)));
        addToBot(new GainEnergyAction(magicNumber));
        addToBot(new ApplyPowerAction(p, p, new CruelCharge(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GalarianArticuno();
    }
}

