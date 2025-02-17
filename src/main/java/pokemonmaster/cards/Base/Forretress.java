package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Forretress extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Forretress",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 9;
    private static final int UPG_BLOCK= 4;



    public Forretress() {
        super(cardInfo,CustomTags.GRASS);

        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Forretress();
    }
}

