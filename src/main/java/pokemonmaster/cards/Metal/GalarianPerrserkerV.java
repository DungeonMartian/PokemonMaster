package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GalarianPerrserkerV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GalarianPerrserkerV",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);


    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE= 3;
    private static final int MEOWDRAW = 2;
    private static final int MEOWDRAWUP = 1;
    private static int CARDDAMAGE = 0;
    public GalarianPerrserkerV() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MEOWDRAW, MEOWDRAWUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot((new ApplyPowerAction(p,p,new DrawCardNextTurnPower(p,magicNumber))));

    }

    @Override
    public void applyPowers() {
        for (int i = 1; i <= AbstractDungeon.player.hand.size() - 1; i++) {
            CARDDAMAGE+=1;
        }
        if (!this.upgraded) {
            this.baseDamage = DAMAGE * CARDDAMAGE;
        }
        if (this.upgraded){
            this.baseDamage=(DAMAGE+UPG_DAMAGE)*CARDDAMAGE;
        }
        CARDDAMAGE = 0;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        super.applyPowers();
    }

    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        for (int i = 1; i <= AbstractDungeon.player.hand.size() - 1; i++) {
            CARDDAMAGE+=1;
        }
        if (!this.upgraded) {
            this.baseDamage = DAMAGE * CARDDAMAGE;
        }
        if (this.upgraded){
            this.baseDamage=(DAMAGE +UPG_DAMAGE)*CARDDAMAGE;
        }
        CARDDAMAGE = 0;
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new GalarianPerrserkerV();
    }
}

