package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.ChoiceCards.BitterBerry;
import pokemonmaster.cards.ChoiceCards.ToughBerry;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shuckle extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Shuckle",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9; //if you change these remember to change the children
    private static final int UPG_BLOCK = 3;
    private static final int POISON = 8;
    private static final int UPG_POISON = 2;

    public Shuckle() {
        super(cardInfo);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.UNEVOLVED);
        setBlock(BLOCK,UPG_BLOCK);
        setMagic(POISON,UPG_POISON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard s = (new ToughBerry());
        AbstractCard t = (new BitterBerry());
        if (upgraded) {
            s.upgrade();
            t.upgrade();
        }
        ArrayList<AbstractCard> ATTACKA = new ArrayList<>();
        s.applyPowers();
        t.applyPowers();
        ATTACKA.add(s);
        ATTACKA.add(t);
        addToBot(new ChooseOneAction(ATTACKA));
        addToBot(new MakeTempCardInHandAction(new Slimed(), 1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shuckle();
    }
}

