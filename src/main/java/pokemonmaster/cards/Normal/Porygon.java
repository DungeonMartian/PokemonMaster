package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Porygon extends BasePokemonCard {
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
        super(cardInfo);
        setMagic(EVOLVE);
        setCostUpgrade(0);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CardTags.HEALING);

        this.purgeOnUse = true;
        this.evolve=new PorygonZ();
        this.cardsToPreview=this.evolve;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SelectCardsInHandAction(magicNumber, "choose card to evolve",false,false, (Predicate<AbstractCard>) card -> card.hasTag(POKEMON), abstractCards -> {
            for (AbstractCard i : abstractCards) {
                addToBot(new EvolveActionCombat(i, "hand"));

            }
        }));
        addToBot(new MakeTempCardInDiscardAction(new Porygon2(), 1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Porygon();
    }
}

