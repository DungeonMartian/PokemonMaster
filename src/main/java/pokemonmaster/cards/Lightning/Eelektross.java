package pokemonmaster.cards.Lightning;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Eelektross extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Eelektross",
            3,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 20;




    public Eelektross() {
        super(cardInfo,CustomTags.LIGHTNING);
        setDamage(DAMAGE);


        this.isMultiDamage = true;
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new StunMonsterAction(monster, p));
                }
            }
        }
        if (this.upgraded) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Tynamo(),1));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Eelektross();
    }
}

