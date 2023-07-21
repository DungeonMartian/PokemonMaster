package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Voltorb extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Voltorb",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int SPARKGAIN = 1;

    private static final int UPG_SPARKGAIN = 1;


    public Voltorb() {
        super(cardInfo, new Electrode(), new Electrode(),CustomTags.LIGHTNING);
        setMagic(SPARKGAIN,UPG_SPARKGAIN);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        int count = AbstractDungeon.player.hand.size();
        for (int i = 0; i < count; i++) {
            addToTop(new ExhaustAction(1, true, true));
        }
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new ExplosionSmallEffect(p.hb.cX, p.hb.cY), 0.1F));

        addToBot(new ApplyPowerAction(p, p, new Spark(p, magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Voltorb();
    }
}

