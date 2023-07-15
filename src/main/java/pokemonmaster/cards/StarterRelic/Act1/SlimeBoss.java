package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SlimeBossPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SlimeBoss extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SlimeBoss",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public SlimeBoss() {
        super(cardInfo);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new SlimeBossPower(p, 1)));
        if (this.upgraded) {
            addToBot(new MakeTempCardInDiscardAction(new ASlimeL(), 1));
            addToBot(new MakeTempCardInDiscardAction(new SSlimeL(), 1));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SlimeBoss();
    }
}

