package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import pokemonmaster.cards.HeldItemCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;
import pokemonmaster.util.Actions.HeldItemAction;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GoldBerry extends HeldItemCard{
    private final static CardInfo cardInfo = new CardInfo(
            "GoldBerry",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private final static int MAGIC = 5;
    public GoldBerry() {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CardTags.HEALING);
    }

    @Override
    public void OnStartup() {
        // heal hp
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new HeldItemAction(new HealAction(p,p,this.magicNumber)));
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
    
    @Override
    public AbstractCard makeCopy() { //Optional
        return new GoldBerry();
    }
}
