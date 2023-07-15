package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.city.Byrd;
import com.megacrit.cardcrawl.powers.RitualPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Cultist extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cultist",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int CULT = 2;
    private static final int UPG_CULT= 1;



    public Cultist() {
        super(cardInfo);
        setMagic(CULT, UPG_CULT);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        AbstractDungeon.actionManager.addToBottom(new TalkAction(true, Byrd.DIALOG[0], 1.2F, 1.2F));
        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new RitualPower(p, magicNumber, true), magicNumber));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cultist();
    }
}

