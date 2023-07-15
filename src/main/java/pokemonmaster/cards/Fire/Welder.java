package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.powers.SupporterPlayed;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Welder extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Welder",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int WELD = 2;




    public Welder() {
        super(cardInfo);
        setMagic(WELD);
        setCostUpgrade(1);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");
        tags.add(CustomTags.SUPPORTER);
    }

    @Override
    public void applyPowers() {

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            addToBot(new ExhaustAction(magicNumber, false));
            addToBot(new DrawCardAction(3));
            addToBot(new ApplyPowerAction(p, p, new Spark(p,magicNumber)));
            addToBot(new ApplyPowerAction(p, p, new SupporterPlayed(p,1)));
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
        return new Welder();
    }
}

