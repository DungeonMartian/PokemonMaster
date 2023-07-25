package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Resistant;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MetalCoreBarrier extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MetalCoreBarrier",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);
//Take 30 less Damage from all attacks this turn. Exhaust.


    public static final String ID = makeID(cardInfo.baseId);

    private static final int DDOWN = 15;
    private static final int DDOWNUP= 10;



    public MetalCoreBarrier() {
        super(cardInfo);
        setMagic(DDOWN, DDOWNUP);
        tags.add(CustomTags.METAL);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new Resistant(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MetalCoreBarrier();
    }
}

