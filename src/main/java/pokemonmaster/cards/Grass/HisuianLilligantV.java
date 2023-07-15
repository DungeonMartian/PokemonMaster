package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.ChoiceCards.*;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HisuianLilligantV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HisuianLilligantV",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 16;
    private static final int CARDDRAW = 2;



    public HisuianLilligantV() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(CARDDRAW);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(1);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        ArrayList<AbstractCard> ATTACKA = new ArrayList<>();
        ATTACKA.add(new DanceGraceful());
        LeafStep LBACK = new LeafStep();
        LBACK.calculateCardDamage(m);
        ATTACKA.add(LBACK);
        addToBot(new ChooseOneAction(ATTACKA));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HisuianLilligantV();
    }
}

