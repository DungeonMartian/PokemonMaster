package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Slugma extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Slugma",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 6;



    public Slugma() {
        super(cardInfo, new Magcargo(), new Magcargo(),CustomTags.FIRE);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        AbstractPower pow = AbstractDungeon.player.getPower(Spark.POWER_ID);
        if (pow != null) {
            if(pow.amount >= 0) {
                AbstractDungeon.player.getPower(Spark.POWER_ID).amount = 0;
                addToBot(new RemoveSpecificPowerAction(p, p, pow));
            }
        }
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.FIRE));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Slugma();
    }
}

