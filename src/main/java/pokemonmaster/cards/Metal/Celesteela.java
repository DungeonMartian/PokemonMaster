package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Celesteela extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Celesteela",
            4,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 40;
    private static final int UPG_DAMAGE = 10;



    public Celesteela() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.isMultiDamage = true;
        this.baseMagicNumber=0;
        isMagicNumberModified = baseMagicNumber != magicNumber;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() == 6) {
            addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        }
    }
    //@Override
    //public void applyPowers() {
    //    magicNumber= AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
    //    this.rawDescription = cardStrings.DESCRIPTION;
    //    this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
    //    this.initializeDescription();
    //    super.applyPowers();
//
    //}

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() == 5)  {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
        }
    }
    //public void onMoveToDiscard() {
    //    this.baseMagicNumber=0;
    //    this.rawDescription = cardStrings.DESCRIPTION;
    //    initializeDescription();
    //}
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Celesteela();
    }
}

