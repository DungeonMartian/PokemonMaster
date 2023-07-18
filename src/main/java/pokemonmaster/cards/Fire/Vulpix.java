package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Vulpix extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Vulpix",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK= 2;



    public Vulpix() {
        super(cardInfo,new Ninetales(),new Ninetales(),CustomTags.FIRE);
        setBlock(BLOCK, UPG_BLOCK);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInHandAction(new Burn(), 1));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Vulpix();
    }
}

