package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.PichuPower;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pichu extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pichu",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;




    public Pichu() {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(2);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerLightning.png","pokemonmaster/character/cardback/bg_powerLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new PichuPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pichu();
    }
}

