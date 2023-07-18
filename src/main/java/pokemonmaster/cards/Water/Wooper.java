package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Wooper extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Wooper",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;
    private static final int UPG_BLOCK= 3;



    public Wooper() {
        super(cardInfo,new Quagsire(),new Quagsire(),CustomTags.WATER);
        setBlock(BLOCK, UPG_BLOCK);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, this.block), this.block));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Wooper();
    }
}

