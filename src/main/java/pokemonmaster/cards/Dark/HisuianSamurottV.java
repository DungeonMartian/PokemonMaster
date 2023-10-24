package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ToolsOfTheTradePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HisuianSamurottV extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HisuianSamurottV",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    private static final int MAGIC = 2;

    public HisuianSamurottV() {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CustomTags.DARK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setInnate(false,true);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerDark.png","pokemonmaster/character/cardback/bg_powerDark_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ToolsOfTheTradePower(p,  magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,  1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HisuianSamurottV();
    }
}

