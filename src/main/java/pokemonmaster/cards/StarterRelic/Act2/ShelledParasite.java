package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ShelledParasite extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShelledParasite",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int ARMOUR = 14;


    public ShelledParasite() {
        super(cardInfo);

        setMagic(ARMOUR);
        setCostUpgrade(2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new PlatedArmorPower(p, magicNumber)));
        }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShelledParasite();
    }
}

