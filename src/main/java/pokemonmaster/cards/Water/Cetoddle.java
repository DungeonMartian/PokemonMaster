package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CetitanAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cetoddle extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cetoddle",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;
    private static final int MAGIC= 2;



    public Cetoddle() {
        super(cardInfo,new Cetitan(), new Cetitan(), CustomTags.WATER);
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
        return new Cetoddle();
    }
}

