package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.FalinksVPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FalinksV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FalinksV",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGS = 2;
    private static final int MAGSUP = 1;
    private static final int BLOCK = 2;
    private static final int BLOCKUP = 1;



    public FalinksV() {
        super(cardInfo);
        setMagic(MAGS, MAGSUP);
        setBlock(BLOCK,BLOCKUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");

    }




    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p,p,block));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new ApplyPowerAction(p, p, new FalinksVPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FalinksV();
    }
}

