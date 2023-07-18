package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Luxray extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Luxray",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 13;
    private static final int UPG_DAMAGE = 3;



    public Luxray() {
        super(cardInfo,CustomTags.LIGHTNING);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        super.onPlayCard(c, m);
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() != 0){
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() % 5 == 0) {
            addToBot(new DiscardToHandAction(this));
        }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Luxray();
    }
}

