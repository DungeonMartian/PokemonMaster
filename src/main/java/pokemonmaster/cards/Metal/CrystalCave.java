package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.CrystalCavePower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class CrystalCave extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CrystalCave",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int CRYSTAL = 5;
    private static final int CRYSTALUP= 2;



    public CrystalCave() {
        super(cardInfo);
        setMagic(CRYSTAL, CRYSTALUP);
        tags.add(CustomTags.METAL);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerMetal.png","pokemonmaster/character/cardback/bg_powerMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new CrystalCavePower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CrystalCave();
    }
}

