package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class IronHands extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "IronHands",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 10;
    private static final int UPG_BLOCK= 4;



    public IronHands() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        AbstractPower pow = AbstractDungeon.player.getPower(pokemonmaster.powers.Spark.POWER_ID);
        if (pow != null ){
            int STRUP = AbstractDungeon.player.getPower(pokemonmaster.powers.Spark.POWER_ID).amount;
            addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,STRUP)));
            AbstractDungeon.player.getPower(Spark.POWER_ID).amount = 0;
            addToBot(new RemoveSpecificPowerAction(p, p, pow));
        }
        addToBot(new ApplyPowerAction(p, p, new Spark(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new IronHands();
    }
}

