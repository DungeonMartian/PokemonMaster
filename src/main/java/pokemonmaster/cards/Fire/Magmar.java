package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.StatusDiscardBlock;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magmar extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magmar",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FIRE = 2;
    private static final int FIREUP = 1;



    public Magmar() {
        super(cardInfo,new Magmortar(),new Magmortar(),CustomTags.FIRE);
        setMagic(FIRE,FIREUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p, new StatusDiscardBlock(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magmar();
    }
}

