package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Ferroseed extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Ferroseed",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 2;
    private static final int DAMAGEDOWN= 4;
    private static final int DAMAGEDOWNUP= 1;


    public Ferroseed() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(DAMAGEDOWN,DAMAGEDOWNUP);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        purgeOnUse = true;
        this.cardsToPreview = new Ferrothorn();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));
        addToBot(new MakeTempCardInDiscardAction(new Ferrothorn(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Ferroseed();
    }
}

