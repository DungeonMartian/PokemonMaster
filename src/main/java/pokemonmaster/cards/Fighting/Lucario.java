package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.EnergyDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Lucario extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Lucario",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int LUCENERGY = 2;
    private static final int LUCENERGYUP = 2;




    public Lucario() {
        super(cardInfo,CustomTags.FIGHTING);
        setMagic(LUCENERGY,LUCENERGYUP);

        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");


    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainEnergyAction(magicNumber));
        addToBot(new ApplyPowerAction(p, p, new EnergyDownPower(p,magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new BufferPower(p,magicNumber)));
        AbstractCard TOADD = new Riolu();
        if (this.upgraded){
            TOADD.upgrade();
        }
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(TOADD, 1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Lucario();
    }
}

