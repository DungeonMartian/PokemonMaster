package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.ChoiceCards.Surf;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Quagsire extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Quagsire",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9;




    public Quagsire() {
        super(cardInfo,CustomTags.WATER);
        setBlock(BLOCK);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, this.block), this.block));
        AbstractCard s = (new Surf()).makeCopy();
        if (this.upgraded) {
            s.upgrade();
        }
        addToBot(new MakeTempCardInHandAction(s,1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Quagsire();
    }
}

