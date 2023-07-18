package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Fletchling extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Fletchling",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DRAW = 1;
    private static final int DAMAGE= 2;
    private static final int UPG_DAMAGE= 3;


    public Fletchling() {
        super(cardInfo,new Fletchinder(),new Talonflame(),CustomTags.FIRE);
        setMagic(DRAW);
        setDamage(DAMAGE,UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DiscardAction(p,p,p.hand.size(),true));
        addToBot(new DrawCardAction(p,magicNumber));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Fletchling();
    }
}

