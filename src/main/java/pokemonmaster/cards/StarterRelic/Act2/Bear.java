package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Bear extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Bear",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC= 2;



    public Bear() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new TalkAction(true, "Hold me Bear!", 1.2F, 1.2F));
        AbstractDungeon.actionManager.addToBottom(new WaitAction(0.5F));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bear();
    }
}

