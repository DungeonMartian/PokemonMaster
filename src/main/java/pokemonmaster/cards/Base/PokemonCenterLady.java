package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
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

public class PokemonCenterLady extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PokemonCenterLady",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);




    public static final String ID = makeID(cardInfo.baseId);

    private static final int LADYHEAL = 20;




    public PokemonCenterLady() {
        super(cardInfo);
        setMagic(LADYHEAL);
        setEthereal(true,false);
        purgeOnUse = true;
        tags.add(CardTags.HEALING);
        tags.add(CustomTags.SUPPORTER);
    }

    @Override
    public void applyPowers() {

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            addToBot(new HealAction(p, p, this.magicNumber));
            addToBot(new RemoveDebuffsAction(AbstractDungeon.player));
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
        return new PokemonCenterLady();
    }
}

