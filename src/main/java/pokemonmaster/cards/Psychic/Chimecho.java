package pokemonmaster.cards.Psychic;

import com.evacipated.cardcrawl.mod.stslib.actions.common.FetchAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.CustomTags.SUPPORTER;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Chimecho extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Chimecho",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public Chimecho() {
        super(cardInfo);
        setCostUpgrade(0);
        this.exhaust=true;
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new FetchAction(p.drawPile, card -> card.hasTag(POKEMON),1, abstractCards -> {
        }));
        addToBot(new FetchAction(p.drawPile, card -> card.hasTag(SUPPORTER),1, abstractCards -> {
        }));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Chimecho();
    }
}

