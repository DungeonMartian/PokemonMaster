package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.ChoiceCards.Shellsmash;
import pokemonmaster.cards.ChoiceCards.Withdraw;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Crustle extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Crustle",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 8;

    public Crustle() {
        super(cardInfo);
        setBlock(BLOCK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.EVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard s = (new Withdraw());
        AbstractCard t = (new Shellsmash());
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

