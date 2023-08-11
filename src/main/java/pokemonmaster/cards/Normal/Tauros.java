package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tauros extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Tauros",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 6;



    public Tauros() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();

    }
    public void calculateCardDamage(AbstractMonster mo) {
        if (!this.upgraded) {
            this.baseDamage = DAMAGE + AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
        }
        if (this.upgraded) {
            this.baseDamage = DAMAGE + UPG_DAMAGE + AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
        }
        super.calculateCardDamage(mo);
        this.rawDescription =  cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }
    public void applyPowers() {
        if (!this.upgraded) {
            this.baseDamage = DAMAGE + AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
        }
        if (this.upgraded) {
            this.baseDamage = DAMAGE + UPG_DAMAGE + AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
        }
        super.applyPowers();
        this.rawDescription =  cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Tauros();
    }
}

