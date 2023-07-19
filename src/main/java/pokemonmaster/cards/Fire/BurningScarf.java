package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.FlameBarrierEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.BurningScarfPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BurningScarf extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BurningScarf",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BURNED = 2;
    private static final int UPG_BURNED= 2;



    public BurningScarf() {
        super(cardInfo);
        setMagic(BURNED, UPG_BURNED);
        tags.add(CustomTags.FIRE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BurningScarfPower(p,magicNumber)));
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.1F));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BurningScarf();
    }
}

