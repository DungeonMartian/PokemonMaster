package pokemonmaster.cards.StarterRelic;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CatchAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pokeball extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pokeball",
            0,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int CULT = 10;

    public Pokeball() {
        super(cardInfo);
        this.purgeOnUse = true;
        setDamage(CULT);
        this.damageType= DamageInfo.DamageType.HP_LOSS;
        this.damageTypeForTurn= DamageInfo.DamageType.HP_LOSS;
        FleetingField.fleeting.set(this, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentHealth <=10) {
            addToBot(new CatchAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn)));

        }

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pokeball();
    }
}

