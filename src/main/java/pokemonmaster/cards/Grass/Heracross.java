package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Guts;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Heracross extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Heracross",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC= 1;



    public Heracross() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new Guts(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Heracross();
    }
}

