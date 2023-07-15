package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LeafeonGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LeafeonGX",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int MAGIC = 3;

    public LeafeonGX() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(MAGIC);
        this.isMultiDamage = true;
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.EVOLVED);
        tags.add(CustomTags.POKEMON);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new WeakPower(monster, magicNumber, false) ));
                }
            }
        }
        if (this.upgraded){
            addToBot(new ApplyPowerAction(p, p, new BufferPower(p,1)));
        }
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LeafeonGX();
    }
}

