package pokemonmaster.cards.Fighting;

import com.evacipated.cardcrawl.mod.stslib.actions.common.FetchAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Baltoy extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Baltoy",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC = 1;



    public Baltoy() {
        super(cardInfo,new Claydol(),new Claydol(),CustomTags.FIGHTING);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new FetchAction(p.drawPile, card -> card.hasTag(POKEMON),magicNumber, abstractCards -> {
        }));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Baltoy();
    }
}

