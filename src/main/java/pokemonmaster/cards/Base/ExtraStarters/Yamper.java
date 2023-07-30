package pokemonmaster.cards.Base.ExtraStarters;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Yamper extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Yamper",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;



    public Yamper() {
        super(cardInfo,new Boltund(),new Boltund(),CustomTags.LIGHTNING);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");


    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new StunMonsterAction(m, p));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Yamper();
    }
}

