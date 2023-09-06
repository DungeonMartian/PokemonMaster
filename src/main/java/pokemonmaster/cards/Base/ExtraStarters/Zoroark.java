package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.BeatUpAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zoroark extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zoroark",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE= 3;

    private static final int MAGIC= 0;
    private int COUNT;

    public Zoroark() {
        super(cardInfo,CustomTags.DARK);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");
        COUNT = 0;
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    @Override
    public void applyPowers() {
        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
            if (c.hasTag(CustomTags.POKEMON)) {
                COUNT +=1;
            }
        }
        this.magicNumber= COUNT;
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
        COUNT=0;
    }
    public void calculateCardDamage(AbstractMonster mo) {
        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
            if (c.hasTag(CustomTags.POKEMON)) {
                COUNT +=1;
            }
        }
        this.magicNumber= COUNT;
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.calculateCardDamage(mo);
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
        COUNT=0;
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BeatUpAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zoroark();
    }
}

