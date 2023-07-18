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
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DrawDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Lairon extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Lairon",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 22;
    private static final int UPG_DAMAGE = 4;
    private static final int DRAWDOWN = 2;



    public Lairon() {
        super(cardInfo,new Aggron(),CustomTags.METAL);
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
        return new Lairon();
    }
}

