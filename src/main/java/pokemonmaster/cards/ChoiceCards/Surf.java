package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Surf extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Surf",
            0,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE= 1;
    private static final int UPG_DAMAGE= 1;




    public Surf() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setSelfRetain(true);
        this.exhaust = true;
        tags.add(CustomTags.CHOICE);
        this.isMultiDamage = true;
        this.rawDescription = cardStrings.DESCRIPTION ;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
            }

    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        if (!this.upgraded) {
            this.baseDamage = EnergyPanel.totalCount * DAMAGE;
        }
        if (this.upgraded) {
            this.baseDamage = EnergyPanel.totalCount * (DAMAGE+UPG_DAMAGE);
        }
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    public void applyPowers() {
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION ;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Surf();
    }
}

