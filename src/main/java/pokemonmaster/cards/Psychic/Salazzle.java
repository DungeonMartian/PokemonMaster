package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Burned;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Salazzle extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Salazzle",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 4;
    private static final int UPG_MAGIC= 1;



    public Salazzle() {
        super(cardInfo,CustomTags.PSYCHIC);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m,p,magicNumber)));
        addToBot(new ApplyPowerAction(m, p, new Burned(m, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Salazzle();
    }
}

