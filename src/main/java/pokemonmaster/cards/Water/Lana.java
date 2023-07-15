package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.LanaPower;
import pokemonmaster.powers.SupporterPlayed;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Lana extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Lana",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC= 1;



    public Lana() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.WATER);
         this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");
        this.exhaust=true;
        tags.add(CustomTags.SUPPORTER);
        tags.add(CardTags.HEALING);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            addToBot(new ApplyPowerAction(p, p, new LanaPower(p, magicNumber)));
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
        return new Lana();
    }
}

