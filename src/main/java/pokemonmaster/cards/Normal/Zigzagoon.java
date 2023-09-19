package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.ZigzagoonAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zigzagoon extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zigzagoon",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    public Zigzagoon() {
        super(cardInfo,new Linoone(), new Linoone(), CustomTags.NORMAL);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ZigzagoonAction((AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng), this.upgraded));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Zigzagoon();
    }
}

