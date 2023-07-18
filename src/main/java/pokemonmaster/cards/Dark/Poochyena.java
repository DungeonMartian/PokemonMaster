package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Poochyena extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Poochyena",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 3;
    private static final int UPG_BLOCK= 1;

    private static final int DDOWN = 1;
    private static final int UPG_DDOWN= 1;

    public Poochyena() {
        super(cardInfo,new Mightyena(),new Mightyena(),CustomTags.DARK);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(DDOWN,UPG_DDOWN);




        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Poochyena();
    }
}

