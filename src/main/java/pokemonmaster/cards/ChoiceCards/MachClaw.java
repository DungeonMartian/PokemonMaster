package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MachClaw extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MachClaw",
            -2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);




    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 3;



    public MachClaw() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        this.isMultiDamage = true;
        tags.add(CustomTags.CHOICE);


    }



    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();
            }


    @Override
    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));}




    @Override
    public AbstractCard makeCopy() { //Optional
        return new MachClaw();
    }
}

