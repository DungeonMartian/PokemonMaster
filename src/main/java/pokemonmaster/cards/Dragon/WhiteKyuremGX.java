package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.BiteEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class WhiteKyuremGX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "WhiteKyuremGX",
            3,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 20;
    private static final int UPG_DAMAGE = 4;




    public WhiteKyuremGX() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new BiteEffect(m.hb.cX, m.hb.cY), 0.3F));

        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        if (this.upgraded){
            this.baseDamage = (DAMAGE + UPG_DAMAGE) ;
        }
        else{
            this.baseDamage = DAMAGE;
        }

    }
    public void applyPowers() {
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth){
            if (this.upgraded){
                this.baseDamage = (DAMAGE + UPG_DAMAGE) *2;
            }
            else{
                this.baseDamage = DAMAGE *2;
            }



        }
        else {
            if (this.upgraded){
                this.baseDamage = (DAMAGE + UPG_DAMAGE) ;
            }
            else{
                this.baseDamage = DAMAGE;
            }

        }
        super.applyPowers();

    }

    @Override
    public void moveToDiscardPile() {
        if (this.upgraded){
            this.baseDamage = (DAMAGE + UPG_DAMAGE) ;

        }
        else{
            this.baseDamage = DAMAGE ;
        }
        super.moveToDiscardPile();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        if (AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth){
            if (this.upgraded){
                this.baseDamage = (DAMAGE + UPG_DAMAGE) *2;
            }
            else{
                this.baseDamage = DAMAGE *2;
            }


        }
        else {
            if (this.upgraded){
                this.baseDamage = (DAMAGE + UPG_DAMAGE) ;
            }
            else{
                this.baseDamage = DAMAGE;
            }

        }
        super.calculateCardDamage(mo);


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new WhiteKyuremGX();
    }
}

