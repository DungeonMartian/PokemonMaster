package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class PorygonEX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PorygonEX",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;

    private boolean DRAGON;
    private boolean DARK;
    private boolean FIRE;
    private boolean FIGHTING;
    private boolean GRASS;
    private boolean LIGHTNING;
    private boolean FAIRY;
    private boolean NORMAL;
    private boolean METAL;
    private boolean WATER;
    private boolean PSYCHIC;

    public PorygonEX() {
        super(cardInfo);
        setMagic(DAMAGE);
        setCostUpgrade(1);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");
        DRAGON = false;
        DARK = false;
        FIRE = false;
        FIGHTING = false;
        GRASS = false;
        LIGHTNING = false;
        FAIRY = false;
        NORMAL = false;
        METAL = false;
        WATER = false;
        PSYCHIC = false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        this.rawDescription = cardStrings.DESCRIPTION;
        this.initializeDescription();
        DRAGON = false;
        DARK = false;
        FIRE = false;
        FIGHTING = false;
        GRASS = false;
        LIGHTNING = false;
        FAIRY = false;
        NORMAL = false;
        METAL = false;
        WATER = false;
        PSYCHIC = false;
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        this.baseDamage = DAMAGE;
        initializeDescription();
        DRAGON = false;
        DARK = false;
        FIRE = false;
        FIGHTING = false;
        GRASS = false;
        LIGHTNING = false;
        FAIRY = false;
        NORMAL = false;
        METAL = false;
        WATER = false;
        PSYCHIC = false;
    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        this.baseDamage=0;
        DRAGON = false;
        DARK = false;
        FIRE = false;
        FIGHTING = false;
        GRASS = false;
        LIGHTNING = false;
        FAIRY = false;
        NORMAL = false;
        METAL = false;
        WATER = false;
        PSYCHIC = false;
        for (AbstractCard J : player.hand.group){
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.DRAGON)){
                this.DRAGON = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.LIGHTNING)){
                this.LIGHTNING = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.GRASS)){
                this.GRASS = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.WATER)){
                this.WATER = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.DARK)){
                this.DARK=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FIRE)){
                this.FIRE=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.PSYCHIC)){
                this.PSYCHIC=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.METAL)){
                this.METAL=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.NORMAL)){
                this.NORMAL=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FIGHTING)){
                this.FIGHTING=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FAIRY)){
                this.FAIRY=true;
            }
        }
        if (this.FAIRY){
            this.baseDamage+= DAMAGE;
        }
        if (this.DARK){
            this.baseDamage+= DAMAGE;
        }
        if (this.DRAGON){
            this.baseDamage+= DAMAGE;
        }
        if (this.METAL){
            this.baseDamage+= DAMAGE;
        }
        if (this.FIGHTING){
            this.baseDamage+= DAMAGE;
        }
        if (this.FIRE){
            this.baseDamage+= DAMAGE;
        }
        if (this.GRASS){
            this.baseDamage+= DAMAGE;
        }
        if (this.LIGHTNING){
            this.baseDamage+= DAMAGE;
        }
        if (this.NORMAL){
            this.baseDamage+= DAMAGE;
        }
        if (this.WATER){
            this.baseDamage+= DAMAGE;
        }
        if (this.PSYCHIC){
            this.baseDamage+= DAMAGE;
        }

        this.rawDescription =cardStrings.DESCRIPTION+ cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }

    @Override
    public void applyPowers() {
        this.baseDamage=0;
        DRAGON = false;
        DARK = false;
        FIRE = false;
        FIGHTING = false;
        GRASS = false;
        LIGHTNING = false;
        FAIRY = false;
        NORMAL = false;
        METAL = false;
        WATER = false;
        PSYCHIC = false;
        for (AbstractCard J : AbstractDungeon.player.hand.group){
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.DRAGON)){
                this.DRAGON = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.LIGHTNING)){
                this.LIGHTNING = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.GRASS)){
                this.GRASS = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.WATER)){
                this.WATER = true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.DARK)){
                this.DARK=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FIRE)){
                this.FIRE=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.PSYCHIC)){
                this.PSYCHIC=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.METAL)){
                this.METAL=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.NORMAL)){
                this.NORMAL=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FIGHTING)){
                this.FIGHTING=true;
            }
            if (J.hasTag(CustomTags.POKEMON) && J.hasTag(CustomTags.FAIRY)){
                this.FAIRY=true;
            }
        }
        if (this.FAIRY){
            this.baseDamage+= DAMAGE;
        }
        if (this.DARK){
            this.baseDamage+= DAMAGE;
        }
        if (this.DRAGON){
            this.baseDamage+= DAMAGE;
        }
        if (this.METAL){
            this.baseDamage+= DAMAGE;
        }
        if (this.FIGHTING){
            this.baseDamage+= DAMAGE;
        }
        if (this.FIRE){
            this.baseDamage+= DAMAGE;
        }
        if (this.GRASS){
            this.baseDamage+= DAMAGE;
        }
        if (this.LIGHTNING){
            this.baseDamage+= DAMAGE;
        }
        if (this.NORMAL){
            this.baseDamage+= DAMAGE;
        }
        if (this.WATER){
            this.baseDamage+= DAMAGE;
        }
        if (this.PSYCHIC){
            this.baseDamage+= DAMAGE;
        }
        this.rawDescription =cardStrings.DESCRIPTION+ cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
        super.applyPowers();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PorygonEX();
    }
}

