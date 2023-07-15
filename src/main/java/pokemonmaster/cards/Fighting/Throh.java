package pokemonmaster.cards.Fighting;

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

public class Throh extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Throh",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    private static final int MAGIC = 14;
    private static final int UPG_MAGIC = 3;

    public Throh() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.FIGHTING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));

    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        if (this.upgraded){
            this.baseDamage = DAMAGE + UPG_DAMAGE;
        }
        else{
            this.baseDamage = DAMAGE ;
        }
        initializeDescription();

    }
    public void applyPowers() {
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth){
            if (this.upgraded){
                this.baseDamage = DAMAGE + UPG_DAMAGE + this.magicNumber;
            }
            else{
                this.baseDamage = DAMAGE + this.magicNumber;
            }

        }
        super.applyPowers();
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth) {
            this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        }
        initializeDescription();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth){
            if (this.upgraded){
                this.baseDamage = DAMAGE + UPG_DAMAGE + this.magicNumber;
            }
            else{
                this.baseDamage = DAMAGE + this.magicNumber;
            }
        }
        super.calculateCardDamage(mo);
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth) {
            this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        }
        initializeDescription();

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Throh();
    }
}

