package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CetitanAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cetitan extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cetitan",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9;
    private static final int UPG_BLOCK= 4;

    private static final int MAGIC= 3;

    public Cetitan() {
        super(cardInfo,CustomTags.WATER);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new CetitanAction(magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cetitan();
    }
}

