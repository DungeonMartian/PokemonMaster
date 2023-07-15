package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.RegielekiPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Regieleki extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Regieleki",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int ZAP = 2;
    private static final int UPG_ZAP= 2;




    public Regieleki() {
        super(cardInfo);
        setMagic(ZAP,UPG_ZAP);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.REGIELEC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerLightning.png","pokemonmaster/character/cardback/bg_powerLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new RegielekiPower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Regieleki();
    }
}

