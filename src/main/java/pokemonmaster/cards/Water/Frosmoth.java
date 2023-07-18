package pokemonmaster.cards.Water;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Frosmoth extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Frosmoth",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);




    public Frosmoth() {
        super(cardInfo,CustomTags.WATER);
        setCostUpgrade(0);

        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        this.magicNumber=p.hand.size();
        addToBot(new SelectCardsInHandAction(this.magicNumber, "Exhaust", true, true, c -> true, list -> {
            for (AbstractCard c : list) {
                addToBot(new ExhaustSpecificCardAction(c,p.hand,true));
                addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 1)));
                addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 1)));
            }
            AbstractDungeon.player.hand.refreshHandLayout();
        }));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Frosmoth();
    }
}

