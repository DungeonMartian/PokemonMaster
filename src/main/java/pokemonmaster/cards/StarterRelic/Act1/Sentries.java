package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sentries extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sentries",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 18;
    private static final int UPG_BLOCK= 2;



    public Sentries() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInDiscardAction(new Dazed(),2));
    if (this.upgraded){
        addToBot(new ApplyPowerAction(p, p, new ArtifactPower(p, 1)));

    }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sentries();
    }
}

