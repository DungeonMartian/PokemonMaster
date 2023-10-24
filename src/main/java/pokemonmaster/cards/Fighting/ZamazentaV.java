package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Barrier;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ZamazentaV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ZamazentaV",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int SHIELD =8;
    private static final int SHIELDUP =4;
    public ZamazentaV() {
        super(cardInfo);
        tags.add(CustomTags.METAL);
        setMagic(SHIELD,SHIELDUP);
        tags.add(CustomTags.POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Prized(p, 1)));

        addToBot(new ApplyPowerAction(p, p, new Barrier(p,magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new ZamazentaV();
    }
}

