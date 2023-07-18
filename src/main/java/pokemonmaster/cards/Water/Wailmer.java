package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Wailmer extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Wailmer",
            -1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;



    public Wailmer() {
        super(cardInfo,new Wailord(),new Wailord(),CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");

    }




    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SkewerAction(p, m, this.damage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Wailmer();
    }
}

