package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.FuryCutterPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Scyther extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Scyther",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;
    private static final int FURY = 4;
    private static final int FURYUP = 2;




    public Scyther() {
        super(cardInfo);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(FURY,FURYUP);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        this.isDamageModified=true;
        this.returnToHand=true;
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new FuryCutterPower(p,magicNumber)));
        this.costForTurn=1;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Scyther();
    }
}

