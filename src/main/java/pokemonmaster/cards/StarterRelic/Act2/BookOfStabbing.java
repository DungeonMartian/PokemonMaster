package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.BookAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BookOfStabbing extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BookOfStabbing",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 1;

    private static final int MAGIC = 2;

    public BookOfStabbing() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        isMagicNumberModified = baseMagicNumber != magicNumber;
        this.shuffleBackIntoDrawPile=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i =1; i <= magicNumber; i++) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        }
        addToBot(new BookAction(this,1));
            }



    @Override
    public AbstractCard makeCopy() { //Optional
        return new BookOfStabbing();
    }
}

