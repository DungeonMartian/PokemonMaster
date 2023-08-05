package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Exeggcute extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Exeggcute",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;



    public Exeggcute() {
        super(cardInfo,new AlolanExeggutor(), new AlolanExeggutor(), CustomTags.GRASS);
        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void triggerOnManualDiscard() {
        super.onMoveToDiscard();
        addToBot(new MakeTempCardInHandAction(new Exeggcute(),magicNumber));
    }
    public void triggerOnExhaust() {
        addToBot(new MakeTempCardInHandAction(new Exeggcute(),magicNumber));
    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Exeggcute(),magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Exeggcute();
    }
}

