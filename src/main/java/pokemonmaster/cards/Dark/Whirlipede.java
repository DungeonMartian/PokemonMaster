package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Whirlipede extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Whirlipede",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC= 8;



    public Whirlipede() {
        super(cardInfo,new Scolipede(),CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,  2)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Whirlipede();
    }
}

