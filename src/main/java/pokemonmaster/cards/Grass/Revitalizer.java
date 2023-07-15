package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FrailPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Revitalizer extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Revitalizer",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int REVIT = 2;



    public Revitalizer() {
        super(cardInfo);
        setMagic(REVIT);
        tags.add(CustomTags.GRASS);
        this.exhaust=true;
        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDiscardPileToHandAction(magicNumber,0));
        AbstractPower FRAILPOW = AbstractDungeon.player.getPower(FrailPower.POWER_ID);
        AbstractPower VULPOW = AbstractDungeon.player.getPower(VulnerablePower.POWER_ID);
        if (FRAILPOW == null) {
            addToBot(new MakeTempCardInHandAction(new Slimed(), 2));
        }
        if (VULPOW == null) {
            addToBot(new MakeTempCardInHandAction(new Slimed(), 2));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Revitalizer();
    }
}

