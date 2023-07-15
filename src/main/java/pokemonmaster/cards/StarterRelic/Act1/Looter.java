package pokemonmaster.cards.StarterRelic.Act1;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Looter extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Looter",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 1;
    private static final int GOLD = 10;
    private static final int UPG_GOLD = 5;


    public Looter() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(GOLD,UPG_GOLD);
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 3);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 3);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new GainGoldAction(this.magicNumber));
            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Looter();
    }
}

