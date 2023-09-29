package pokemonmaster.cards.Base;

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
import pokemonmaster.powers.SupporterPlayed;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ProfessorSycamore extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ProfessorSycamore",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
        public ProfessorSycamore() {
        super(cardInfo);
            tags.add(CustomTags.SUPPORTER);
        setCostUpgrade(0);
        this.exhaust = true;
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            int count = AbstractDungeon.player.hand.size();
            int i;
            for (i = 0; i < count; i++) {
                    addToTop(new ExhaustAction(1, true, true));
                }
            addToBot(new DrawCardAction(7));
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
        return new ProfessorSycamore();
    }
}

