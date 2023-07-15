package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.CollectorPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Collector extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Collector",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int MAGIC = 3;


    public Collector() {
        super(cardInfo);
        setMagic(MAGIC);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new CollectorPower(p,2)));
        if (this.upgraded) {
            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new StrengthPower(p,magicNumber)));

        }
        }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Collector();
    }
}

