package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.ChoiceCards.BigOne;
import pokemonmaster.cards.ChoiceCards.Dud;
import pokemonmaster.cards.ChoiceCards.Firework;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Blacephalon extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Blacephalon",
            2,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    public Blacephalon() {
        super(cardInfo);

        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setExhaust(true,false);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int PHEALTH= p.currentHealth;
        int MHEALTH = m.currentHealth;
        int MIN = 1;
        int MAX = 3;
        int BOMBS = 4;
        if (PHEALTH > MHEALTH) {BOMBS = 12;}
        for (int i = 0; i < BOMBS; i++) {
            int RANDOM_INT = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
            if (RANDOM_INT == 1){addToBot(new MakeTempCardInHandAction(new Firework(),1));}
            if (RANDOM_INT == 2){addToBot(new MakeTempCardInHandAction(new Dud(),1));}
            if (RANDOM_INT ==3) {addToBot(new MakeTempCardInHandAction(new BigOne(),1));}
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Blacephalon();
    }
}

