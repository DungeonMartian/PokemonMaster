package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DrawDownPower;
import pokemonmaster.powers.EnergyDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Snorlax extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Snorlax",
            4,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = -2;

    public Snorlax() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");
        tags.add(CardTags.HEALING);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new HealAction(p,p, 100000));
        addToBot(new ApplyPowerAction(p, p, new EnergyDownPower(p,magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new DrawDownPower(p,magicNumber)));
        addToBot(new PressEndTurnButtonAction());


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Snorlax();
    }
}

