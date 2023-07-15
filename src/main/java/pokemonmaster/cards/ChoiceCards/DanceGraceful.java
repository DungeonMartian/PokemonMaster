package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DanceGraceful extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DanceGraceful",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 8;
    private static final int BLOCKNEXT = 6;



    public DanceGraceful() {
        super(cardInfo);
        setBlock(BLOCK);
        setMagic(BLOCKNEXT);
        tags.add(CustomTags.CHOICE);
    }

    @Override


    public void use(AbstractPlayer p, AbstractMonster m) {
        onChoseThisOption();

    }

    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new ExpertiseAction(p, 6));
        addToBot(new GainEnergyAction(2));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DanceGraceful();
    }
}

