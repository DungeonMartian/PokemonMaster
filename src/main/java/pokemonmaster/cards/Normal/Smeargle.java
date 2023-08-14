package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.SmeargleAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Smeargle extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Smeargle",
            2,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public Smeargle() {
        super(cardInfo);
        setCostUpgrade(1);
        tags.add(CardTags.HEALING);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SmeargleAction(m));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Smeargle();
    }
}

