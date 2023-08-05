package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanExeggutor extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanExeggutor",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;
    private static final int MAGIC = 0;


    public AlolanExeggutor() {
        super(cardInfo,CustomTags.GRASS);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    public void applyPowers() {
        this.magicNumber=0;
        if (AbstractDungeon.player.discardPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.discardPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        if (AbstractDungeon.player.exhaustPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.drawPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        if (AbstractDungeon.player.drawPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.drawPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        for (AbstractCard i : AbstractDungeon.player.hand.group) {
            if (i instanceof Exeggcute){
                magicNumber+=1;
            }
        }
        if (!this.upgraded) {
            this.baseDamage = DAMAGE * magicNumber;
        }
        if (this.upgraded) {
            this.baseDamage = (DAMAGE + UPG_DAMAGE) * magicNumber;
        }
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        super.applyPowers();
    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        this.magicNumber=0;
        if (AbstractDungeon.player.discardPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.discardPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        if (AbstractDungeon.player.exhaustPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.drawPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        if (AbstractDungeon.player.drawPile.size() != 0){
            for (AbstractCard i : AbstractDungeon.player.drawPile.group) {
                if (i instanceof Exeggcute){
                    magicNumber+=1;
                }
            }
        }
        for (AbstractCard i : AbstractDungeon.player.hand.group) {
            if (i instanceof Exeggcute){
                magicNumber+=1;
            }
        }
        if (!this.upgraded) {
            this.baseDamage = DAMAGE * magicNumber;
        }
        if (this.upgraded) {
            this.baseDamage = (DAMAGE + UPG_DAMAGE) * magicNumber;
        }
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new AlolanExeggutor();
    }
}

