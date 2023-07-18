package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pineco2 extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pineco2",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;
    private static final int UPG_BLOCK= 2;



    public Pineco2() {
        super(cardInfo, new Forretress(),new Forretress(),CustomTags.GRASS);

        setBlock(BLOCK, UPG_BLOCK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CardTags.STARTER_DEFEND);

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pineco2();
    }
}

