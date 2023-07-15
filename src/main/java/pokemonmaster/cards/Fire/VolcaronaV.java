package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class VolcaronaV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "VolcaronaV",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int DAMAGEUP = 3;




    public VolcaronaV() {
        super(cardInfo);
        setDamage(DAMAGE,DAMAGEUP);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.isMultiDamage = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(Spark.POWER_ID);
        if (pow != null ) {
            int BURNBURN = AbstractDungeon.player.getPower(Spark.POWER_ID).amount;
            for (int i = 1; i <= BURNBURN; i++){
                addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        }
            AbstractDungeon.player.getPower(Spark.POWER_ID).amount = 0;
            addToBot(new RemoveSpecificPowerAction(p, p, pow));
        }

        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new VolcaronaV();
    }
}

