package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Mandibuzz extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Mandibuzz",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 4;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 2;


    public Mandibuzz() {
        super(cardInfo,CustomTags.DARK);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        if (m != null && m.getIntentBaseDmg() >= 0) {

            addToBot(new ApplyPowerAction(m, p, new WeakPower(m, magicNumber, false)));
            addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, magicNumber, false)));

        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Mandibuzz();
    }
}

