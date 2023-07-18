package pokemonmaster.cards.Water;

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
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Chewtle extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Chewtle",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;
    private static final int DAMAGEDOWN = 2;
    private static final int UPG_DAMAGEDOWN = 2;


    public Chewtle() {
        super(cardInfo,new Dreadnaw(),new Dreadnaw(),CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DAMAGEDOWN,UPG_DAMAGEDOWN);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Chewtle();
    }
}

