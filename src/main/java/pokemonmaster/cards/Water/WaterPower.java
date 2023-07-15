package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class WaterPower extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;



    public WaterPower() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.purgeOnUse = this.evolve !=null;
        this.evolve=null;
        this.cardsToPreview=this.evolve;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerWater.png","pokemonmaster/character/cardback/bg_powerWater_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new WaterPower();
    }
}

