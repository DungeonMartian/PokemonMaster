package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Porygon extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Porygon",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int EVOLVE = 1;


    public Porygon() {
        super(cardInfo,new Porygon2(),new PorygonZ(),CustomTags.NORMAL);
        setMagic(EVOLVE);
        setCostUpgrade(0);


        tags.add(CardTags.HEALING);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SelectCardsInHandAction(magicNumber, "evolve",false,false, card -> card.hasTag(CustomTags.POKEMON) && (card.cardsToPreview != null || !card.upgraded), abstractCards -> {
            for (AbstractCard i : abstractCards) {
                addToBot(new EvolveActionCombat(i, "hand"));

            }
        }));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Porygon();
    }
}

