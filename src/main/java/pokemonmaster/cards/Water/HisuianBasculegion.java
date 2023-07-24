package pokemonmaster.cards.Water;

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

public class HisuianBasculegion extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HisuianBasculegion",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    private int COUNTING = 0;

    public HisuianBasculegion() {
        super(cardInfo,CustomTags.WATER);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");

    }

    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        COUNTING=0;
        this.rawDescription = cardStrings.DESCRIPTION;
        for (AbstractCard j : player.discardPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : player.hand.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : player.drawPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : player.exhaustPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        this.baseDamage = COUNTING*this.magicNumber;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }

    @Override
    public void moveToDiscardPile() {
        COUNTING=0;
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
        super.moveToDiscardPile();
    }

    @Override
    public void applyPowers() {
        COUNTING=0;
        this.rawDescription = cardStrings.DESCRIPTION;
        for (AbstractCard j : AbstractDungeon.player.discardPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : AbstractDungeon.player.hand.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : AbstractDungeon.player.drawPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        for (AbstractCard j : AbstractDungeon.player.exhaustPile.group){
            if (j.type == CardType.STATUS){
                COUNTING +=1;
            }
        }
        this.baseDamage = COUNTING*this.magicNumber;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
        super.applyPowers();
    }
    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        COUNTING=0;
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HisuianBasculegion();
    }
}

