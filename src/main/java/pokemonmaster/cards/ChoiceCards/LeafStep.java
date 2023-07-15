package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LeafStep extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LeafStep",
            -2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 16;
    private static final int CARDDRAW = 2;

    public LeafStep() {
        super(cardInfo);
        this.isMultiDamage = true;
        setDamage(DAMAGE);
        setMagic(CARDDRAW);
        tags.add(CustomTags.CHOICE);
    }

    @Override

    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();
    }
    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p,2)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LeafStep();
    }
}

