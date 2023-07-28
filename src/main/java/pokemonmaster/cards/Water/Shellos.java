package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shellos extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Shellos",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC= 2;



    public Shellos() {
        super(cardInfo,new Gastrodon(), new Gastrodon(),CustomTags.WATER);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.BAIT);
        this.misc = 35;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new HealAction(p,p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shellos();
    }
}

