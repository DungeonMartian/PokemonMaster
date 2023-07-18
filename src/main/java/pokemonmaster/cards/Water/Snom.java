package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Snom extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Snom",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);




    public Snom() {
        super(cardInfo,new Frosmoth(),new Frosmoth(),CustomTags.WATER);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");
        tags.add(CustomTags.BAIT);
        this.misc=40;
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ExhaustAction(1, false));
        addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 1)));
        if (this.upgraded) {
            addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 1)));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Snom();
    }
}

