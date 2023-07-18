package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.TakeDamagePower;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Diglett extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Diglett",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 5;



    public Diglett() {
        super(cardInfo,new Dugtrio(),new Dugtrio(),CustomTags.FIGHTING);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");
        this.isMultiDamage = true;

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(p, p, new TakeDamagePower(p,5)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Diglett();
    }
}

