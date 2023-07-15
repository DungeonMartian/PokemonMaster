package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
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

public class Celebi extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Celebi",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public Celebi() {
        super(cardInfo);
        setCostUpgrade(1);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SelectCardsInHandAction(p.hand.size(), "choose card to evolve",false,false, (Predicate<AbstractCard>) card -> card.hasTag(POKEMON), abstractCards -> {
            for (AbstractCard i : abstractCards) {
                addToBot(new EvolveActionCombat(i, "hand"));
            }
        }));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Celebi();
    }
}

