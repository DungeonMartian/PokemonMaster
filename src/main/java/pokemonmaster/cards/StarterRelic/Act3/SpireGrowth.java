package pokemonmaster.cards.StarterRelic.Act3;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SpireGrowth extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SpireGrowth",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 10;
    private static final int UPG_MAGIC= 5;



    public SpireGrowth() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new ConstrictedPower(m,p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SpireGrowth();
    }
}

