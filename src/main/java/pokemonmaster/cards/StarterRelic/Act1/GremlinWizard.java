package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.GremlinWizardPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GremlinWizard extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GremlinWizard",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 1;

    private static final int WEAKEN = 20;


    public GremlinWizard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(WEAKEN);
        setExhaust(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.upgraded){
            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new GremlinWizardPower(p, 3), magicNumber));
        }
        if (!this.upgraded){
            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new GremlinWizardPower(p, 3), magicNumber));
        }
            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GremlinWizard();
    }
}

