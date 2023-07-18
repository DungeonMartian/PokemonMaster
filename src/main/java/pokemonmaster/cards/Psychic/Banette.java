package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.unique.ExhumeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Banette extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Banette",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public Banette() {
        super(cardInfo,CustomTags.PSYCHIC);

        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        int count = AbstractDungeon.player.hand.size();
        int i;
        for (i = 0; i < count; i++) {
            addToTop(new ExhaustAction(1, true, true, false ));
        }
        addToBot(new ExhumeAction(false));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Banette();
    }
}

