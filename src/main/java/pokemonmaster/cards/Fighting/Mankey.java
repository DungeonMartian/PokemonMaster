package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.WoundedPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Mankey extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Mankey",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 20;
    private static final int UPG_DAMAGE = 5;



    public Mankey() {
        super(cardInfo,new Primeape(),new Primeape(),CustomTags.FIGHTING);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new WoundedPower(p,1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Mankey();
    }
}

