package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BigOne extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BigOne",
            0,
            CardType.STATUS,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            AbstractCard.CardColor.COLORLESS);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;




    public BigOne() {
        super(cardInfo);
        setDamage(DAMAGE);
        this.exhaust=true;
        this.isMultiDamage = true;
        this.damageType= DamageInfo.DamageType.THORNS;
        this.damageTypeForTurn= DamageInfo.DamageType.THORNS;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new ExplosionSmallEffect(monster.hb.cX, monster.hb.cY), 0.1F));
                }
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BigOne();
    }
}

