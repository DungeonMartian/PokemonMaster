package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Firework extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Firework",
            0,
            CardType.STATUS,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;



    public Firework() {
        super(cardInfo);
        setDamage(DAMAGE);
        this.exhaust=true;
        this.damageType= DamageInfo.DamageType.THORNS;
        this.damageTypeForTurn= DamageInfo.DamageType.THORNS;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.FIRE));
            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Firework();
    }
}

