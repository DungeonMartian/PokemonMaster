package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.OricorioPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class OricorioFire extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "OricorioFire",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FIRE = 1;




    public OricorioFire() {
        super(cardInfo);
        setMagic(FIRE);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.POKEMON);
        setInnate(false,true);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p, new OricorioPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new OricorioFire();
    }
}

