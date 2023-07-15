package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GrassBlock extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;



    public GrassBlock() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.purgeOnUse = this.evolve !=null;
        this.evolve=null;
        this.cardsToPreview=this.evolve;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new EvolveActionCombat(this.evolve,"discard"));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GrassBlock();
    }
}

