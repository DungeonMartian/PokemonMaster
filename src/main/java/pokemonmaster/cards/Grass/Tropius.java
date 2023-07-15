package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.TropiusAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tropius extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Tropius",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private static final int POTUSE = 1;
    private static final int POTUSEUP = 1;



    public Tropius() {
        super(cardInfo);
        setMagic(POTUSE, POTUSEUP);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 3);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 3);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new TropiusAction(m, magicNumber));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Tropius();
    }
}

