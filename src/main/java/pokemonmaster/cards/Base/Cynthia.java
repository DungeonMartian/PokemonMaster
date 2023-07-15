package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SupporterPlayed;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cynthia extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cynthia",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);
    private static final int CYNTHIADRAW = 6;


    public static final String ID = makeID(cardInfo.baseId);
        public Cynthia() {
        super(cardInfo);
        setMagic(CYNTHIADRAW);
        this.exhaust=true;
        setCostUpgrade(0);
            tags.add(CustomTags.SUPPORTER);
    }

    @Override
    public void applyPowers() {

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            addToBot(new ShuffleAllAction());
            addToBot(new ShuffleAction(AbstractDungeon.player.drawPile, false));
            addToBot(new DrawCardAction(p, 6));
            addToBot(new ApplyPowerAction(p, p, new SupporterPlayed(p, 1)));
        }
    }
    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cynthia();
    }
}

