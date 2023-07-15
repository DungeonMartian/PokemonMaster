package pokemonmaster.cards.StarterRelic;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CatchAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SafariBall extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SafariBall",
            0,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int CULT = 20;

    public SafariBall() {
        super(cardInfo);
        this.purgeOnUse = true;
        setDamage(CULT);
        this.damageType= DamageInfo.DamageType.HP_LOSS;
        this.damageTypeForTurn= DamageInfo.DamageType.HP_LOSS;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentHealth <=20) {
            //addToBot(new DamageAction(m, new DamageInfo(p, 10, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            addToBot(new CatchAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn)));
           //if (((m).isDying || m.currentHealth <= 0) && !m.halfDead &&
           //        !m.hasPower("Minion")) {
           //    addToTop(new AddCardToDeckAction(AddThis(m.id)));
           //    addToBot(new MakeTempCardInDiscardAction(AddThis(m.id), 1));
           //}
        }

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new SafariBall();
    }
}

