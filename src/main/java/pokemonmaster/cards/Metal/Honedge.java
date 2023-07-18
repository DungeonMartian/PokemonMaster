package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Honedge extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Honedge",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int STRE = 1;
    private static final int STREUP = 1;
    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE= 1;
    public Honedge() {
        super(cardInfo,new Doublade(),new Aegislash(),CustomTags.METAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(STRE, STREUP);

        tags.add(CardTags.STRIKE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Honedge();
    }
}

