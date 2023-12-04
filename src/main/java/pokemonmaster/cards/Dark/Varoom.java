package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.cards.Metal.Magnet;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.AcidSpray;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Varoom extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Varoom",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC= 2;
    private static final int UPG_MAGIC=1;



    public Varoom() {
        super(cardInfo,new Revavroom(),new Revavroom(),CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerDark.png","pokemonmaster/character/cardback/bg_powerDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Magnet(), 1));
        addToBot(new ApplyPowerAction(p, p, new AcidSpray(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Varoom();
    }
}

