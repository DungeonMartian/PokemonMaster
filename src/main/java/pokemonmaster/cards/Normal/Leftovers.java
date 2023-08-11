package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import pokemonmaster.cards.HeldItemCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.HeldItemAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Leftovers extends HeldItemCard{
    private final static CardInfo cardInfo = new CardInfo(
            "Leftovers",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private final static int MAGIC = 2;
    private final static int UPG_MAGIC = 1;
    public Leftovers() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CardTags.HEALING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }

    @Override
    public void OnStartup() {

        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new HeldItemAction(new ApplyPowerAction(p, p, new RegenPower(p, magicNumber))));

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
    
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Leftovers();
    }
}
