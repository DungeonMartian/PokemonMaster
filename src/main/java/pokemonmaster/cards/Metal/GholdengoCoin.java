package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GholdengoCoin extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GholdengoCoin",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int ENERGY = 1;
    private static final int ENERGYUP = 1;



    public GholdengoCoin() {
        super(cardInfo);
        this.exhaust = true;
        setMagic(ENERGY, ENERGYUP);
        this.misc = 25;
        tags.add(CustomTags.BAIT);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainEnergyAction(magicNumber));
        addToBot(new DrawCardAction(magicNumber));
        AbstractDungeon.effectList.add(new RainingGoldEffect(this.magicNumber * 2, true));
        addToBot(new GainGoldAction(this.magicNumber*25));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GholdengoCoin();
    }
}

