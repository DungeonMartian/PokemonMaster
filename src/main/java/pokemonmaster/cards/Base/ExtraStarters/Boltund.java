package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
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

public class Boltund extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Boltund",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 4;

    public static final String ID = makeID(cardInfo.baseId);

    public Boltund() {
        super(cardInfo, CustomTags.LIGHTNING);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >=4){
            this.cost =0;
            this.costForTurn =0;
            this.isCostModified=true;
        }
        else {
            this.cost =2;
            this.costForTurn =2;
            this.isCostModified=false;
        }
        super.calculateCardDamage(mo);
    }
    @Override
    public void applyPowers() {
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >=4){
            this.cost =0;
            this.costForTurn =0;
            this.isCostModified=true;
        }
        else {
            this.cost =2;
            this.costForTurn =2;
            this.isCostModified=false;
        }
        super.applyPowers();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Boltund();
    }
}

