package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.cards.HeldItemCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MachoBrace extends HeldItemCard{
    private final static CardInfo cardInfo = new CardInfo(
            "MachoBrace",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private final static int MAGIC = 1;
    private final static int UPG_MAGIC = 1;
    public MachoBrace() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }

    @Override
    public void OnStartup() {

        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.player.increaseMaxHp(magicNumber,  true);
        addToBot(new DamageAction(p, new DamageInfo(p, 4, DamageInfo.DamageType.THORNS)));

    }


    
    @Override
    public AbstractCard makeCopy() { //Optional
        return new MachoBrace();
    }
}
