package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.NecrozmaAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class UltraNecrozmaV extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "UltraNecrozmaV",
            -1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 11;

    private static final int MAGIC = 0;
    private static final int UPG_MAGIC = 2;


    public UltraNecrozmaV() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new NecrozmaAction(p, m, this.damage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse+magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new UltraNecrozmaV();
    }
}

