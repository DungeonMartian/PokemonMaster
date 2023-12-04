package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.RedFireballEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyDownPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class InfernapeV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "InfernapeV",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 40;
    private static final int DAMAGEUP = 10;




    public InfernapeV() {
        super(cardInfo);
        setDamage(DAMAGE,DAMAGEUP);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new RedFireballEffect(m.hb.cX-5* Settings.scale,m.hb.cY,m.hb.cX+5* Settings.scale,m.hb.cY, 3), 0.1F));

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new ApplyPowerAction(p, p, new EnergyDownPower(p,2)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new InfernapeV();
    }
}

