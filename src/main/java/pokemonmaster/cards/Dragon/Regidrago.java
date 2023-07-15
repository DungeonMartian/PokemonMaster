package pokemonmaster.cards.Dragon;

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

public class Regidrago extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Regidrago",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 50;
    private static final int UPG_DAMAGE = 15;




    public Regidrago() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.REGIDRAGO);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));


    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }
    @Override
    public void applyPowers() {
        if (!this.upgraded) {
            int NEWDAMAGE = DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        if (this.upgraded){
            int NEWDAMAGE = DAMAGE+ UPG_DAMAGE + 2*(AbstractDungeon.player.currentHealth - AbstractDungeon.player.maxHealth);
            this.baseDamage = NEWDAMAGE;

        }
        super.applyPowers();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Regidrago();
    }
}

