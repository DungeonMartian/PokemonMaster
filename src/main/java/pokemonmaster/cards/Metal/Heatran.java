package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Smelt;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Heatran extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Heatran",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGS = 1;





    public Heatran() {
        super(cardInfo);
        setMagic(MAGS);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }




    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Smelt(p,1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Heatran();
    }
}

