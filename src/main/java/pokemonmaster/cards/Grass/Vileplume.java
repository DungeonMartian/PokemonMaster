package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.VileplumePower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Vileplume extends FinalEvolutionCard {
    private static final int GREENANGRY = 1;



    private final static CardInfo cardInfo = new CardInfo(
            "Vileplume",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public Vileplume() {
        super(cardInfo,CustomTags.GRASS);

        setMagic(GREENANGRY);
        setSelfRetain(false,true);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new VileplumePower(p,magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p,99,false)));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Vileplume();
    }
}

