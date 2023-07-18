package pokemonmaster.cards.Psychic;

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

public class Garbodor extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Garbodor",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 1;
    private static final int UPG_DAMAGE= 1;
    private int COUNT =0;


    public Garbodor() {
        super(cardInfo,CustomTags.PSYCHIC);
        setMagic(DAMAGE,UPG_DAMAGE);

        this.isMultiDamage=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, damage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new MakeTempCardInDiscardAction(new Trubbish(),1));
    }

    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        if (player.exhaustPile.size() >0) {
            COUNT =0;
            if (!AbstractDungeon.player.exhaustPile.isEmpty()) {
                for (AbstractCard i : player.exhaustPile.group){
                    if (i.type == AbstractCard.CardType.STATUS) {
                        COUNT += 1;
                    }
                }
                if (this.upgraded) {
                    this.baseDamage = COUNT * DAMAGE+UPG_DAMAGE;
                }
                else {
                    this.baseDamage = COUNT * DAMAGE;
                }
            }

            this.rawDescription = cardStrings.DESCRIPTION;
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }

        return super.calculateModifiedCardDamage(player, mo, tmp);
    }

    @Override
    public void applyPowers() {
        if (AbstractDungeon.player.exhaustPile.size() >0) {
            COUNT =0;
            if (!AbstractDungeon.player.exhaustPile.isEmpty()) {
                for (AbstractCard i : AbstractDungeon.player.exhaustPile.group){
                    if (i.type == AbstractCard.CardType.STATUS) {
                        COUNT += 1;
                    }
                }
                if (this.upgraded) {
                    this.baseDamage = COUNT * DAMAGE+UPG_DAMAGE;
                }
                else {
                    this.baseDamage = COUNT * DAMAGE;
                }
            }
            this.rawDescription = cardStrings.DESCRIPTION;
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }

        super.applyPowers();
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Garbodor();
    }
}

