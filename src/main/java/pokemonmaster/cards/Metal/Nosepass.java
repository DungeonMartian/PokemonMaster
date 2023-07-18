package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Nosepass extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Nosepass",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);

    private static final int NOSEBLOCK = 1;
    private static final int NOSEBLOCKUP = 1;
    public static final String ID = makeID(cardInfo.baseId);





    public Nosepass() {
        super(cardInfo, new Probopass(), new Probopass(),CustomTags.METAL);
        setMagic(NOSEBLOCK, NOSEBLOCKUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");


    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Magnet(), 1));
        applyPowers();
        addToBot(new GainBlockAction(p, p, this.block+1));

    }

    public void applyPowers() {
        int count = 0;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c != this)
                count++;
        }
        this.baseBlock = count * this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Nosepass();
    }
}

