package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Morelull extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Morelull",
            2,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;

    private static final int LULLDEBURFF = 1;




    public Morelull() {
        super(cardInfo,new Shiinotic(),new Shiinotic(),CustomTags.GRASS);
        setBlock(BLOCK);
        setMagic(LULLDEBURFF);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        if (upgraded) {
            addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, -this.magicNumber), -this.magicNumber));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Morelull();
    }
}

