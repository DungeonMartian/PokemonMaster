package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.StormyMountainPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class StormyMountain extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "StormyMountain",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public StormyMountain() {
        super(cardInfo);
        setInnate(false,true);
        tags.add(CustomTags.LIGHTNING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerLightning.png","pokemonmaster/character/cardback/bg_powerLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new StormyMountainPower(p,1)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new StormyMountain();
    }
}

