package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ShroomishPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shroomish extends BasicPokemonCard {

    private final static CardInfo cardInfo = new CardInfo(
            "Shroomish",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);
    private static final int MUSHPUNCH = 15;
    private static final int MUSHPUNCHUP = 4;


    public static final String ID = makeID(cardInfo.baseId);





    public Shroomish() {
        super(cardInfo,new Breloom(),new Breloom(),CustomTags.GRASS);

        setMagic(MUSHPUNCH, MUSHPUNCHUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new ShroomishPower(p, magicNumber)));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(4);
            this.cardsToPreview.upgrade();
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shroomish();
    }
}

