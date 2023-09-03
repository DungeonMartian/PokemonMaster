package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.BufferPower;
import pokemonmaster.cards.HeldItemCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Resistant;
import pokemonmaster.util.Actions.HeldItemAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AirBalloon extends HeldItemCard{
    private final static CardInfo cardInfo = new CardInfo(
            "AirBalloon",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private final static int MAGIC = 4;

    public AirBalloon() {
        super(cardInfo);
        setMagic(MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void OnStartup() {

        AbstractPlayer p = AbstractDungeon.player;

            addToBot(new HeldItemAction(new ApplyPowerAction(p, p, new Resistant(p, magicNumber))));

        if (this.upgraded) {
            addToBot(new HeldItemAction(new ApplyPowerAction(p, p, new BufferPower(p, 1))));

        }
    }


    
    @Override
    public AbstractCard makeCopy() { //Optional
        return new AirBalloon();
    }
}
