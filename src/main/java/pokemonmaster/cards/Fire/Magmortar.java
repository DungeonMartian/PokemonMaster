package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.StatusDiscardDamage;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Magmortar extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Magmortar",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int FIRE = 4;
    private static final int FIREUP = 4;




    public Magmortar() {
        super(cardInfo);
        setMagic(FIRE,FIREUP);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.EVOLVED);
        tags.add(CustomTags.POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFire.png","pokemonmaster/character/cardback/bg_powerFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p, new StatusDiscardDamage(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Magmortar();
    }
}

