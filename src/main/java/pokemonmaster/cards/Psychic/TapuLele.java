package pokemonmaster.cards.Psychic;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.ShakeScreenAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.combat.GiantEyeEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class TapuLele extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "TapuLele",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 3;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public TapuLele() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        float ENERGY =  (float) EnergyPanel.getCurrentEnergy() /3;
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new GiantEyeEffect(m.hb.cX, m.hb.cY, Color.PURPLE), 0.1F * ENERGY));
        if (ENERGY < 5) {
            addToBot(new ShakeScreenAction(.1f, ScreenShake.ShakeDur.SHORT, ScreenShake.ShakeIntensity.LOW));
        }
        else if (ENERGY > 5 && ENERGY < 10) {
            addToBot(new ShakeScreenAction(.1f, ScreenShake.ShakeDur.MED, ScreenShake.ShakeIntensity.MED));
        }
        else{
            addToBot(new ShakeScreenAction(.1f, ScreenShake.ShakeDur.LONG, ScreenShake.ShakeIntensity.HIGH));

        }
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));

    }

    @Override
    public void applyPowers() {
        this.baseDamage = DAMAGE +  (EnergyPanel.getCurrentEnergy() *magicNumber);
        super.applyPowers();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        this.baseDamage = DAMAGE +  (EnergyPanel.getCurrentEnergy() *magicNumber);
    }

    @Override
    public void onMoveToDiscard() {
        this.baseDamage = DAMAGE;
        super.onMoveToDiscard();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TapuLele();
    }
}

