package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class InciniroarV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "InciniroarV",
            5,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int DAMAGEUP = 10;




    public InciniroarV() {
        super(cardInfo);
        setDamage(DAMAGE,DAMAGEUP);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(Spark.POWER_ID);
        if (pow != null ) {
            int STRUP = AbstractDungeon.player.getPower(Spark.POWER_ID).amount;
            addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,STRUP)));
            AbstractDungeon.player.getPower(Spark.POWER_ID).amount = 0;
            addToBot(new RemoveSpecificPowerAction(p, p, pow));
        }

            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));


        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }

    public void applyPowers() {
        AbstractPower pow = AbstractDungeon.player.getPower(Spark.POWER_ID);
        if (pow != null ) {
            if (this.upgraded) {
                int STRUP = AbstractDungeon.player.getPower(Spark.POWER_ID).amount;
                this.baseDamage = DAMAGEUP + pow.amount;
            }
            if (!this.upgraded) {
                int STRUP = AbstractDungeon.player.getPower(Spark.POWER_ID).amount;
                this.baseDamage = DAMAGE + pow.amount;
            }
        }
        if (pow == null ) {

            if (this.upgraded) {

                this.baseDamage = DAMAGE+ DAMAGEUP ;
            }
            if (!this.upgraded) {

                this.baseDamage = DAMAGE ;
            }
        }

            super.applyPowers();
            this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new InciniroarV();
    }
}

