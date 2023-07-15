package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConfusionPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sneko extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sneko",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int ARMOUR = 15;


    public Sneko() {
        super(cardInfo);
        setInnate(false,true);

        }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new ConfusionPower(p)));
        AbstractDungeon.player.gameHandSize+=2;
        }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sneko();
    }
}

