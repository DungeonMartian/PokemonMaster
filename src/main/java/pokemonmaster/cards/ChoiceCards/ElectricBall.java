package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ElectricBall extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ElectricBall",
            -2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);




    public static final String ID = makeID(cardInfo.baseId);

    public ElectricBall() {
        super(cardInfo);
        tags.add(CustomTags.CHOICE);
        this.baseDamage = this.damage = AbstractDungeon.actionManager.cardsPlayedThisTurn.size();

    }



    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();
            }



    @Override
    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new AttackDamageRandomEnemyAction(this));

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new ElectricBall();
    }
}

