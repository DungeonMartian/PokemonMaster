package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Aegislash extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Aegislash",
            1,
            CardType.ATTACK,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int STAT = 3;
    private static final int STATUP = 1;
    private static final int BLOCK = 16;
    private static final int UPG_BLOCK= 1;

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE= 1;

    public Aegislash() {
        super(cardInfo,CustomTags.METAL);
        setBlock(BLOCK, UPG_BLOCK);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(STAT,STATUP);
        this.exhaust = true;
        this.isMultiDamage = true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.ATTACK){
            addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
            addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));
        }
        else if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == AbstractCard.CardType.SKILL){
            addToBot(new GainBlockAction(p, p, block));
            addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));
        }
        else; {
        }
    }

    public void triggerOnGlowCheck() {
        if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.SKILL) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription =  cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }
        else if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == AbstractCard.CardType.ATTACK) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription =  cardStrings.EXTENDED_DESCRIPTION[1];
            initializeDescription();
        }
        else {
            this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
            this.rawDescription = cardStrings.DESCRIPTION;
            initializeDescription();
        }

    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Aegislash();
    }
}

