package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zorua extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zorua",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE= 3;



    public Zorua() {
        super(cardInfo,new Zoroark(),new Zoroark(),CustomTags.DARK);
        setDamage(DAMAGE,UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
        addToBot(new DrawCardAction(p,1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zorua();
    }
}

