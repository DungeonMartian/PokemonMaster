package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.DiscardDrawnAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Drampa extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Drampa",
            2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 5;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;


    public Drampa() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.isMultiDamage = true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new DrawCardAction(this.magicNumber, new DiscardDrawnAction()));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Drampa();
    }
}

