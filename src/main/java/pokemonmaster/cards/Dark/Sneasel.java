package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sneasel extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sneasel",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 1;

    private static final int MAGIC = -1;

    public Sneasel() {
        super(cardInfo, new Weavile(), new Weavile(), CustomTags.DARK);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

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
        this.magicNumber=-1;
        for (AbstractCard j : AbstractDungeon.player.hand.group){
            if (j.hasTag(CustomTags.POKEMON)){
                this.magicNumber+=Math.max(j.cost,j.costForTurn);
            }
        }

        if (!this.upgraded) {
            this.baseDamage = DAMAGE * (magicNumber);


        }
        if (this.upgraded){
            this.baseDamage = DAMAGE+ UPG_DAMAGE + (magicNumber);


        }
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        super.applyPowers();
    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        this.magicNumber=-1;
        for (AbstractCard j : player.hand.group){
            if (j.hasTag(CustomTags.POKEMON)){
                this.magicNumber+=Math.max(j.cost,j.costForTurn);
            }
        }

        if (!this.upgraded) {
            this.baseDamage = DAMAGE * (magicNumber);


        }
        if (this.upgraded){
            this.baseDamage = DAMAGE+ UPG_DAMAGE + (magicNumber);


        }
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sneasel();
    }
}

