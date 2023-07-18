package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DrawDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Aron extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Aron",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 4;
    private static final int DRAWDOWN = 1;



    public Aron() {
        super(cardInfo,new Lairon(),new Aggron(),CustomTags.METAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DRAWDOWN);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new DrawDownPower(p,DRAWDOWN)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Aron();
    }
}

