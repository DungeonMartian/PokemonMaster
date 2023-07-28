package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Grubbin extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Grubbin",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int SPARK = 1;
    private static final int UPG_SPARK= 1;



    public Grubbin() {
        super(cardInfo,new Charjabug(),new Vikavolt(),CustomTags.LIGHTNING);
        setMagic(SPARK, UPG_SPARK);
        tags.add(CustomTags.BAIT);
        this.misc = 25;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {


        addToBot(new ApplyPowerAction(p, p, new Spark(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Grubbin();
    }
}

