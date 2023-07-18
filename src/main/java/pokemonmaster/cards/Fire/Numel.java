package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Numel extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Numel",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 3;
    private static final int BURNMAGIC = 1;
    private static final int BURNMAGICUP = 1;



    public Numel() {
        super(cardInfo,new Camerupt(),new Camerupt(),CustomTags.FIRE);
        setDamage(DAMAGE);
        setMagic(BURNMAGIC,BURNMAGICUP);
        this.isMultiDamage = true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < this.magicNumber; i++){
            addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
            addToBot(new MakeTempCardInHandAction(new Burn(), 1));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Numel();
    }
}

