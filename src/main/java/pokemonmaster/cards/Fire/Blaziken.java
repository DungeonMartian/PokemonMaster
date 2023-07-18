package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Blaziken extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Blaziken",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 20;
    private static final int DAMAGEUP = 5;

    private static final int DEXUP = 3;


    public Blaziken() {
        super(cardInfo,CustomTags.FIRE);
        setDamage(DAMAGE,DAMAGEUP);

        setMagic(DEXUP);
        this.exhaust=true;


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Blaziken();
    }
}

