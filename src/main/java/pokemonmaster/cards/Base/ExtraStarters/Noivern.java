package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.DiscardDrawnAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Noivern extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Noivern",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    private static final int MAGIC = 1;


    public Noivern() {
        super(cardInfo,CustomTags.DRAGON);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);

        this.isMultiDamage = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new DrawCardAction(this.magicNumber, new DiscardDrawnAction()));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Noivern();
    }
}

