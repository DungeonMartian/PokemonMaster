package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.TakeDamagePower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tynamo extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Tynamo",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 5;




    public Tynamo() {
        super(cardInfo,new Eelektrik(),new Eelektross(),CustomTags.LIGHTNING);
        setMagic(MAGIC);

        setCostUpgrade(2);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p,1)));
        addToBot(new ApplyPowerAction(p, p, new TakeDamagePower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Tynamo();
    }
}

