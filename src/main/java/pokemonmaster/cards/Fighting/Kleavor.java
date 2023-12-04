package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.FuryCutterPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Kleavor extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Kleavor",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 5;
    private static final int FURY = 3;



    public Kleavor() {
        super(cardInfo);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(FURY);
        tags.add(CustomTags.FIGHTING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.returnToHand=true;
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot(new ApplyPowerAction(p, p, new FuryCutterPower(p,magicNumber)));
        addToBot(new DamageAction(p, new DamageInfo(p, magicNumber, DamageInfo.DamageType.THORNS)));

        this.costForTurn=1;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Kleavor();
    }
}

