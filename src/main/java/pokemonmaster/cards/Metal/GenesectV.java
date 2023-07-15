package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EntangleNext;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GenesectV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GenesectV",
            3,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 30;
    private static final int UPG_DAMAGE = 5;
    private static final int DRAW = 6;
    private static final int DRAWUP = 1;


    public GenesectV() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DRAW, DRAWUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ExpertiseAction(p, this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new ApplyPowerAction(p, p, new EntangleNext(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GenesectV();
    }
}

