package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Firework extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Firework",
            0,
            CardType.STATUS,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            AbstractCard.CardColor.COLORLESS);



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
        AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        addToBot(new DamageAction(randomMonster, new DamageInfo(p, damage, DamageInfo.DamageType.THORNS)));
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new ExplosionSmallEffect(randomMonster.hb.cX, randomMonster.hb.cY), 0.1F));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Firework();
    }
}

