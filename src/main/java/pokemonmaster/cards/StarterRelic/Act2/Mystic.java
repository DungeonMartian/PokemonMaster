package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Mystic extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Mystic",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int STR = 2;
    private static final int UPG_STR= 2;
    private static final int BLOCK = 16;



    public Mystic() {
        super(cardInfo);
        setBlock(BLOCK);
        setMagic(STR, UPG_STR);
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new HealAction(p, p, 16));
        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new StrengthPower(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Mystic();
    }
}

