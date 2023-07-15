package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.VoltAbsorb;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ThundurusV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ThundurusV",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public ThundurusV() {
        super(cardInfo);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(2);
        this.cardsToPreview=null;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerLightning.png","pokemonmaster/character/cardback/bg_powerLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new VoltAbsorb(p,0)));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ThundurusV();
    }
}

