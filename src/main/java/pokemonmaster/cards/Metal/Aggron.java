package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DrawDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Aggron extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Aggron",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 28;
    private static final int UPG_DAMAGE = 10;
    private static final int DRAWDOWN = 3;



    public Aggron() {
        super(cardInfo,CustomTags.METAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DRAWDOWN);
        this.isMultiDamage = true;
        
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(p, p, new DrawDownPower(p,DRAWDOWN)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Aggron();
    }
}

