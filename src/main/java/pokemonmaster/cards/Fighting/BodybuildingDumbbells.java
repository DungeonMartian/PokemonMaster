package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BodybuildingDumbbells extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BodybuildingDumbbells",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 3;




    public BodybuildingDumbbells(int upgrades) {
        super(cardInfo);
        setMagic(MAGIC);
        tags.add(CustomTags.FIGHTING);
        tags.add(CardTags.HEALING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerFighting.png","pokemonmaster/character/cardback/bg_powerFighting_p.png");
        this.timesUpgraded = upgrades;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.player.increaseMaxHp(magicNumber,  true);

    }
    public void upgrade() {
        upgradeMagicNumber(1);
        this.timesUpgraded++;
        this.upgraded = true;
        this.name = cardStrings.NAME + "+" + this.timesUpgraded;
        initializeTitle();
    }
    public boolean canUpgrade() {
        return true;
    }
    public BodybuildingDumbbells() {
        this(0);
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new BodybuildingDumbbells();
    }
}

