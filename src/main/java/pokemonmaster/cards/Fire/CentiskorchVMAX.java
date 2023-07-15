package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyDownPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CentiskorchVMAX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CentiskorchVMAX",
            -1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.BASIC
            ,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 3;



    public CentiskorchVMAX() {
        super(cardInfo);
        this.isMultiDamage = true;
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.EVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, p.energy.energyMaster));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new ApplyPowerAction(p, p, new Spark(p,1)));
        addToBot(new ApplyPowerAction(p, p, new EnergyDownPower(p,2)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CentiskorchVMAX();
    }
}

