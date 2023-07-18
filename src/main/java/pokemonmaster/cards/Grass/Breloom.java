package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.BreloomPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Breloom extends FinalEvolutionCard {

    private final static CardInfo cardInfo = new CardInfo(
            "Breloom",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);
    private static final int MUSHPUNCH = 20;
    private static final int MUSHPUNCHUP = 5;


    public static final String ID = makeID(cardInfo.baseId);





    public Breloom() {
        super(cardInfo,CustomTags.GRASS);

        setMagic(MUSHPUNCH, MUSHPUNCHUP);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BreloomPower(p,magicNumber)));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Breloom();
    }
}

