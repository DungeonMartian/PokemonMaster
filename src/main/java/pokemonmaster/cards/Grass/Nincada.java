package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Nincada extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Nincada",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;

    private static final int NINBUF = 1;
    private static final int NINBUFUP = 1;


    public Nincada() {
        super(cardInfo,new Ninjask(),new Ninjask(),CustomTags.GRASS);
        setDamage(DAMAGE);
        setMagic(NINBUF,NINBUFUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new BufferPower(p,magicNumber)));
        addToBot(new MakeTempCardInDiscardAction(new Shedinja(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Nincada();
    }
}

