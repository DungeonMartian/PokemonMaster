package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SSlimeL extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SSlimeL",
            3,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 20;
    private static final int UPG_DAMAGE = 4;


    public SSlimeL() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.BAIT);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new MakeTempCardInDiscardAction(new SSlimeM(),2));

            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SSlimeL();
    }
}

