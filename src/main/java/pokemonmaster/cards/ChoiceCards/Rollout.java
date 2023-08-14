package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Rollout extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Rollout",
            -2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 1;



    public Rollout() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.CHOICE);

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();

    }

    public void onChoseThisOption() {

        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.BLUNT_HEAVY));

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Rollout();
    }
}

