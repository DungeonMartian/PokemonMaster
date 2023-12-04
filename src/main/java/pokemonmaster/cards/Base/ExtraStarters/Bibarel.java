package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Barrier;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Bibarel extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Bibarel",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE= 4;

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public Bibarel() {
        super(cardInfo,CustomTags.NORMAL);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
        addToBot(new ApplyPowerAction(p, p, new Barrier(p, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bibarel();
    }
}

