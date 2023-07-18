package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.Actions.LaprasVMAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LaprasVMAX extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LaprasVMAX",
            0,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 3;



    public LaprasVMAX() {
        super(cardInfo,CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.isMultiDamage = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");
        this.rawDescription = cardStrings.DESCRIPTION ;

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new LaprasVMAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, EnergyPanel.totalCount));
        addToBot(new ApplyPowerAction(p, p, new Prized(p, 1)));
    }

    public void applyPowers() {
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION ;
        int COUNT = EnergyPanel.totalCount;
        if (EnergyPanel.totalCount == 0 ) {
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0] + COUNT +cardStrings.EXTENDED_DESCRIPTION[1];
        }
        if (EnergyPanel.totalCount >= 0 ) {
            this.rawDescription +=cardStrings.EXTENDED_DESCRIPTION[0] +COUNT +cardStrings.EXTENDED_DESCRIPTION[2];
        }
        initializeDescription();
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION ;
        initializeDescription();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new LaprasVMAX();
    }
}

