package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.OldCemeteryPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class OldCemetary extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "OldCemetery",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int MAGIC = 6;
    private static final int UPG_MAGIC = 4;
    public OldCemetary() {
        super(cardInfo);
        tags.add(CustomTags.PSYCHIC);

        setMagic(MAGIC,UPG_MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerPsychic.png","pokemonmaster/character/cardback/bg_powerPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new OldCemeteryPower(p,magicNumber)));


    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new OldCemetary();
    }
}
