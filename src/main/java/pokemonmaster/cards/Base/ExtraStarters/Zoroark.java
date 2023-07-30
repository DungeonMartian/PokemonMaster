package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
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



    public Zoroark() {
        super(cardInfo,CustomTags.DARK);
        setDamage(DAMAGE,UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
        addToBot(new BeatUpAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zoroark();
    }
}

