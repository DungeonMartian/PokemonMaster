package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cacturne extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cacturne",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int DAMAGEUP = 2;
    private static final int THORNS = 5;
    private static final int THORNSUP = 3;



    public Cacturne() {
        super(cardInfo,CustomTags.GRASS);
        setDamage(DAMAGE, DAMAGEUP);
        setMagic(THORNS, THORNSUP);

        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        if (this.target != null && m.getIntentBaseDmg() >= 0) {
            addToBot(new ApplyPowerAction(p, p, new ThornsPower(p,magicNumber)));
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        }
    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        for (AbstractMonster m : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!m.isDeadOrEscaped() && m.getIntentBaseDmg() >= 0) {
                this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
                break;
            }
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cacturne();
    }
}

