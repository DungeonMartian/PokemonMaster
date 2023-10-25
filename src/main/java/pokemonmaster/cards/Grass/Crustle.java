package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.ChoiceCards.Shellsmash;
import pokemonmaster.cards.ChoiceCards.Withdraw;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Crustle extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Crustle",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 6;
    private static final int UPG_BLOCK = 2;

    public Crustle() {
        super(cardInfo,CustomTags.GRASS);
        setBlock(BLOCK,UPG_BLOCK);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");


    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        AbstractCard s = (new Withdraw());
        AbstractCard t = (new Shellsmash());
        if (this.upgraded){
            s.upgrade();
            t.upgrade();
        }
        ArrayList<AbstractCard> ATTACKA = new ArrayList<>();
        s.applyPowers();
        t.applyPowers();
        ATTACKA.add( s);
        ATTACKA.add( t);
        addToBot(new ChooseOneAction(ATTACKA));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Crustle();
    }
}

