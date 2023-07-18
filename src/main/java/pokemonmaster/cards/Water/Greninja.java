package pokemonmaster.cards.Water;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ShieldEnergyPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Greninja extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Greninja",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE =1;
    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 1;



    public Greninja() {
        super(cardInfo,CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");
        this.rawDescription = cardStrings.DESCRIPTION;
         this.exhaust=true;
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.ATTACK){
            addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));
        }
        else if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.SKILL){
            addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));
        }
        else if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.POWER){
            addToBot(new ApplyPowerAction(p, p, new ShieldEnergyPower(p, magicNumber)));
        }
        else if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.STATUS){
            addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m,magicNumber,false)));
            addToBot(new ApplyPowerAction(m, p, new WeakPower(m,magicNumber,false)));
        }
        else if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 2).type == CardType.CURSE){
            addToBot(new StunMonsterAction(m,p));
        }
    }

    public void triggerOnGlowCheck() {
        if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.SKILL) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription = cardStrings.DESCRIPTION +cardStrings.EXTENDED_DESCRIPTION[1]+ cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }
        else if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.ATTACK) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0]+ cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }
        else if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.POWER) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[2]+ cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }
        else if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.STATUS) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription =  cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[3]+ cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }
        else if (!AbstractDungeon.actionManager.cardsPlayedThisCombat.isEmpty() && AbstractDungeon.actionManager.cardsPlayedThisCombat
                .get(AbstractDungeon.actionManager.cardsPlayedThisCombat
                        .size() - 1).type == CardType.CURSE) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            this.rawDescription =  cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[4]+ cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }
        else {
            this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
            this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[5];
            initializeDescription();
        }

    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[5];
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Greninja();
    }
}

