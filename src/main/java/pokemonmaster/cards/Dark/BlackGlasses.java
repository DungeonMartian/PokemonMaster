package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.cards.HeldItemCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.HeldItemAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BlackGlasses extends HeldItemCard{
    private final static CardInfo cardInfo = new CardInfo(
            "BlackGlasses",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private final static int MAGIC = 2;
    private final static int UPG_MAGIC = 2;

    public BlackGlasses() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }

    @Override
    public void OnStartup() {

        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new HeldItemAction(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber))));
    }


    
    @Override
    public AbstractCard makeCopy() { //Optional
        return new BlackGlasses();
    }
}
