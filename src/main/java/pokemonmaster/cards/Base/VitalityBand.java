package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class VitalityBand extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "VitalityBand",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int STRUP = 1;
    private static final int STRUPUP = 1;




    public VitalityBand() {
        super(cardInfo);
        setMagic(STRUP, STRUPUP);


    }




    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new VitalityBand();
    }
}

