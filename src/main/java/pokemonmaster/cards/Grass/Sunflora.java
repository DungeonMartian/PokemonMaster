package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sunflora extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sunflora",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK= 4;

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;


    public Sunflora() {
        super(cardInfo,CustomTags.GRASS);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));

        for(AbstractCard l : p.hand.group){
            if (l.type==CardType.STATUS){
                addToBot(new AddTemporaryHPAction(p,p,magicNumber));
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sunflora();
    }
}

