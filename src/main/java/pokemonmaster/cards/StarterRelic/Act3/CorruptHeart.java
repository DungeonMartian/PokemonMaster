package pokemonmaster.cards.StarterRelic.Act3;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.HeartMegaDebuffEffect;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CatchAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CorruptHeart extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CorruptHeart",
            3,
            CardType.SKILL,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    private static final int CULT = 666666;

    public CorruptHeart() {
        super(cardInfo);
        setDamage(CULT);
        setCostUpgrade(2);
        this.damageType= DamageInfo.DamageType.HP_LOSS;
        this.damageTypeForTurn= DamageInfo.DamageType.HP_LOSS;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            AbstractDungeon.actionManager.addToTop(new VFXAction(new HeartMegaDebuffEffect()));
            AbstractDungeon.actionManager.addToTop(new WaitAction(1));
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new CatchAction(monster,new DamageInfo(p, this.damage, this.damageTypeForTurn)));
                }
            }
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CorruptHeart();
    }
}

