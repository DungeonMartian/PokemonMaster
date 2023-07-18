package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ToolsOfTheTradePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Liepard extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Liepard",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;



    public Liepard() {
        super(cardInfo,CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerDark.png","pokemonmaster/character/cardback/bg_powerDark_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ToolsOfTheTradePower(p,  magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Liepard();
    }
}

