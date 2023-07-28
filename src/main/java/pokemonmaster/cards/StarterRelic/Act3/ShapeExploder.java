package pokemonmaster.cards.StarterRelic.Act3;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.TheBombPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ShapeExploder extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShapeExploder",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 30;
    private static final int UPG_DAMAGE =  10;



    public ShapeExploder() {
        super(cardInfo);
        setMagic(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.BAIT);
        this.misc = 80;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new TheBombPower(p, 3, this.magicNumber), 3));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShapeExploder();
    }
}

