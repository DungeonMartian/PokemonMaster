package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Raichu extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Raichu",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);

    private static final int DAMAGE = 11;
    private static final int UPG_DAMAGE = 4;
    private static final int RECOI= 2;
    private static final int RECOIUP= 0;

    public static final String ID = makeID(cardInfo.baseId);

    public Raichu() {
        super(cardInfo, CustomTags.LIGHTNING);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(RECOI,RECOIUP);
        tags.add(CustomTags.POKEMON);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {



     }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new DamageAction(p, new DamageInfo(p, magicNumber, DamageInfo.DamageType.THORNS)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Raichu();
    }
}

