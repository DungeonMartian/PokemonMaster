package pokemonmaster.cards.Fire;

import com.evacipated.cardcrawl.mod.stslib.actions.common.DamageCallbackAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Darmanitan extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Darmanitan",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 2;


    public Darmanitan() {
        super(cardInfo,CustomTags.FIRE);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,magicNumber)));
        addToBot(new DamageCallbackAction(p, new DamageInfo(p, (int) (damage*.5), DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.NONE, integer -> {
            //addToBot(new DamageAction(p, new DamageInfo(p, integer, DamageInfo.DamageType.THORNS)));
        }));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Darmanitan();
    }
}

