package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class UrsalunaV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "UrsalunaV",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 40;
    private static final int UPG_DAMAGE = 10;
    private static final int DAMAGEDOWN = 5;
    private static final int UPG_DAMAGEDOWN = 2;

    public UrsalunaV() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DAMAGEDOWN, UPG_DAMAGEDOWN);
        tags.add(CustomTags.FIGHTING);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));

    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }

    @Override
    public void applyPowers() {
        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + (AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        super.applyPowers();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new UrsalunaV();
    }
}

