package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Jangmoo extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Jangmoo",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);







    public Jangmoo() {
        super(cardInfo,new Hakamoo(),new Kommoo(),CustomTags.DRAGON);
        setCostUpgrade(0);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));


    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();

    }
    public void calculateCardDamage(AbstractMonster mo) {
        this.baseDamage = (AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth)/3;
        super.calculateCardDamage(mo);
        this.rawDescription =  cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }
    public void applyPowers() {
        this.baseDamage =(AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth)/3;
        super.applyPowers();
        this.rawDescription =  cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Jangmoo();
    }
}

