package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.DamageDownPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shelgon extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Shelgon",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9;
    private static final int UPG_BLOCK= 2;
    private static final int MAGIC = 5;
    private static final int UPG_MAGIC= 1;


    public Shelgon() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");
        this.evolve=new Salamence();
        this.purgeOnUse = this.evolve !=null;

        this.cardsToPreview=this.evolve;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DamageDownPower(p,magicNumber)));

        //addToBot(new EvolveActionCombat(this,"discard"));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shelgon();
    }
}

